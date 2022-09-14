package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.dto.LeagueTableRow;
import ir.maktab.sports.competition.model.dto.ScoringDto;
import ir.maktab.sports.competition.repository.FootballGameRepository;
import ir.maktab.sports.competition.repository.FootballTeamRepository;
import ir.maktab.sports.competition.repository.LeagueRepository;

import java.sql.SQLException;
import java.util.List;

public class FootballGameService implements GameService {
    private LeagueRepository footballLeagueRepository = new LeagueRepository();
    private FootballTeamRepository footballTeamRepository = new FootballTeamRepository();

    private FootballGameRepository footballGameRepository = new FootballGameRepository();

    public void addGame(AddGameDto addGameDto) {
        try {
            doAddGame(addGameDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void doAddGame(AddGameDto addGameDto) throws SQLException {
        int leagueId = footballLeagueRepository.findFootballLeagueId();
        int hostTeamId = footballTeamRepository.getIdByName(addGameDto.getHostTeam());
        int opponentTeamId = footballTeamRepository.getIdByName(addGameDto.getOpponent());
        int winnerId;
        if (addGameDto.getHostTeamGoals() > addGameDto.getOpponentGoals()) {
            winnerId = hostTeamId;
            Competition competition = new Competition(hostTeamId, opponentTeamId, winnerId, leagueId);
            footballGameRepository.saveGame(competition);

        } else if (addGameDto.getOpponentGoals() > addGameDto.getHostTeamGoals()) {
            winnerId = opponentTeamId;
            Competition competition = new Competition(hostTeamId, opponentTeamId, winnerId, leagueId);
            footballGameRepository.saveGame(competition);
        } else {
            Competition competition = new Competition(hostTeamId, opponentTeamId, leagueId);
            footballGameRepository.saveDrawGame(competition);
        }
        updateScores(addGameDto, leagueId);
    }

    private void updateScores(AddGameDto addGameDto, int leagueId) throws SQLException {

        if (addGameDto.getHostTeamGoals() > addGameDto.getOpponentGoals()) {
            int score = footballTeamRepository.getScoreByName(addGameDto.getHostTeam(), leagueId) + 3;
            ScoringDto hostScore = new ScoringDto(addGameDto.getHostTeam(), score, leagueId);
            footballTeamRepository.updateScoreByName(hostScore);
        } else if (addGameDto.getOpponentGoals() > addGameDto.getHostTeamGoals()) {
            int score = footballTeamRepository.getScoreByName(addGameDto.getOpponent(), leagueId) + 3;
            ScoringDto opponentScore = new ScoringDto(addGameDto.getOpponent(), score, leagueId);
            footballTeamRepository.updateScoreByName(opponentScore);
        } else {
            int opponentScore = footballTeamRepository.getScoreByName(addGameDto.getOpponent(), leagueId) + 1;
            ScoringDto score1 = new ScoringDto(addGameDto.getOpponent(), opponentScore, leagueId);
            footballTeamRepository.updateScoreByName(score1);
            int hostScore = footballTeamRepository.getScoreByName(addGameDto.getHostTeam(), leagueId) + 1;
            ScoringDto score2 = new ScoringDto(addGameDto.getHostTeam(), hostScore, leagueId);
            footballTeamRepository.updateScoreByName(score2);
        }

    }

    public List<LeagueTableRow> leagueTable() {
        int footballLeagueId = footballLeagueRepository.findFootballLeagueId();
        List<Integer> teamIdList = footballTeamRepository.findFootballTeamIdList(footballLeagueId);
        return footballGameRepository.loadLeagueTableRows(teamIdList);
    }

}
