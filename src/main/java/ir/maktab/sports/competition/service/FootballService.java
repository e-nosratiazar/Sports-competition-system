package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.dto.ScoringDto;
import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.repository.footballrepository.FootballLeagueRepository;
import ir.maktab.sports.competition.repository.footballrepository.FootballTeamRepository;

import java.sql.SQLException;
import java.util.List;

public class FootballService {

    FootballTeamRepository footballTeamRepository = new FootballTeamRepository();
    FootballLeagueRepository footballLeagueRepository = new FootballLeagueRepository();

    public String save(FootballTeam team) {
        try {
            int footballLeagueId = footballLeagueRepository.findFootballLeagueId();
            int num = footballTeamRepository.save(team, footballLeagueId);
            if (num == 1) {
                return "saved successfully";
            } else {
                return "Error while saving team";
            }
        } catch (Exception e) {
            return "Error while saving team";
        }
    }

    public List<FootballTeam> loadAllFootballTeams() throws SQLException {
        int footballLeagueId = footballLeagueRepository.findFootballLeagueId();
        return footballTeamRepository.loadAllTeams(footballLeagueId);
    }

    public String removeByName(String teamName) {
        try {
            int footballLeagueId = footballLeagueRepository.findFootballLeagueId();
            int num = footballTeamRepository.removeByName(teamName, footballLeagueId);
            if (num == 1) {
                return "removed successfully";
            } else {
                return "failed to remove";
            }
        } catch (Exception e) {
            return "failed to remove";
        }
    }

    public FootballTeam showInformationByName(String teamName) {
        try {
            return footballTeamRepository.showInformationTeamByName(teamName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addGame(AddGameDto addGameDto) throws SQLException {
        int leagueId = footballLeagueRepository.findFootballLeagueId();
        int hostTeamId = footballTeamRepository.getIdByName(addGameDto.getHostTeam());
        int opponentTeamId = footballTeamRepository.getIdByName(addGameDto.getOpponent());
        int winnerId;
        if (addGameDto.getHostTeamGoals() > addGameDto.getOpponentGoals()) {
            winnerId = hostTeamId;
            Competition competition = new Competition(hostTeamId, opponentTeamId, winnerId, leagueId);
            footballLeagueRepository.saveGame(competition);

        } else if (addGameDto.getOpponentGoals() > addGameDto.getHostTeamGoals()) {
            winnerId = opponentTeamId;
            Competition competition = new Competition(hostTeamId, opponentTeamId, winnerId, leagueId);
            footballLeagueRepository.saveGame(competition);
        } else {
            Competition competition = new Competition(hostTeamId, opponentTeamId, leagueId);
            footballLeagueRepository.saveDrawGame(competition);
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


}
