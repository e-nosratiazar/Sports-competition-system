package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.dto.LeagueTableRow;
import ir.maktab.sports.competition.model.dto.ScoringDto;
import ir.maktab.sports.competition.repository.LeagueRepository;
import ir.maktab.sports.competition.repository.VolleyballGameRepository;
import ir.maktab.sports.competition.repository.VolleyballTeamRepository;

import java.sql.SQLException;
import java.util.List;

public class VolleyballGameService implements GameService {

    LeagueRepository leagueRepository = new LeagueRepository();
    VolleyballTeamRepository volleyballTeamRepository = new VolleyballTeamRepository();
    VolleyballGameRepository volleyballGameRepository = new VolleyballGameRepository();

    @Override
    public void addGame(AddGameDto addGameDto) {
        try {
            doAddGame(addGameDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void doAddGame(AddGameDto addGameDto) throws SQLException {
        int leagueId = leagueRepository.findVolleyballLeagueId();
        int hostTeamId = volleyballTeamRepository.getIdByName(addGameDto.getHostTeam());
        int opponentTeamId = volleyballTeamRepository.getIdByName(addGameDto.getOpponent());
        String winnerTeam = findWinnerName(addGameDto);
        int winnerId = volleyballTeamRepository.getIdByName(winnerTeam);
        Competition competition = new Competition(hostTeamId, opponentTeamId, winnerId, leagueId);
        volleyballGameRepository.saveGame(competition);
        updateScores(addGameDto, leagueId);
    }


    public void updateScores(AddGameDto addGameDto, int leagueId) throws SQLException {
        int wonSetsSum = addGameDto.getHostTeamGoals() + addGameDto.getOpponentGoals();
        if (wonSetsSum == 3 || wonSetsSum == 4) {
            updateScoresFor4MinusSets(addGameDto, leagueId);
        } else if (wonSetsSum == 5) {
            updateScoresFor5Sets(addGameDto, leagueId);
        }
    }

    private void updateScoresFor5Sets(AddGameDto addGameDto, int leagueId) throws SQLException {
        if (addGameDto.getHostTeamGoals() == 3) {
            String winner = addGameDto.getHostTeam();
            int winnerScore = volleyballTeamRepository.getScoreByName(winner) + 2;
            ScoringDto winnerDto = new ScoringDto(winner, winnerScore, leagueId);
            volleyballTeamRepository.updateScoresByTeamNames(winnerDto);
            String loser = addGameDto.getOpponent();
            int loserScore = volleyballTeamRepository.getScoreByName(loser) + 1;
            ScoringDto looserDto = new ScoringDto(loser, loserScore, leagueId);
            volleyballTeamRepository.updateScoresByTeamNames(looserDto);

        } else if (addGameDto.getOpponentGoals() == 3) {
            String winner = addGameDto.getOpponent();
            int winnerScore = volleyballTeamRepository.getScoreByName(winner) + 2;
            ScoringDto scoringDto = new ScoringDto(winner, winnerScore, leagueId);
            volleyballTeamRepository.updateScoresByTeamNames(scoringDto);
            String loser = addGameDto.getHostTeam();
            int loserScore = volleyballTeamRepository.getScoreByName(loser) + 1;
            ScoringDto scoringDto1 = new ScoringDto(loser, loserScore, leagueId);
            volleyballTeamRepository.updateScoresByTeamNames(scoringDto1);
        }
    }

    private void updateScoresFor4MinusSets(AddGameDto addGameDto, int leagueId) throws SQLException {
        if (addGameDto.getHostTeamGoals() == 3) {
            String winner = addGameDto.getHostTeam();
            int winnerScore = volleyballTeamRepository.getScoreByName(winner) + 3;
            ScoringDto scoringDto = new ScoringDto(winner, winnerScore, leagueId);
            volleyballTeamRepository.updateScoresByTeamNames(scoringDto);
        } else if (addGameDto.getOpponentGoals() == 3) {
            String winner = addGameDto.getOpponent();
            int winnerScore = volleyballTeamRepository.getScoreByName(winner) + 3;
            ScoringDto scoringDto = new ScoringDto(winner, winnerScore, leagueId);
            volleyballTeamRepository.updateScoresByTeamNames(scoringDto);
        }
    }

    private String findWinnerName(AddGameDto addGameDto) {
        if (addGameDto.getHostTeamGoals() > addGameDto.getOpponentGoals()) {
            return addGameDto.getHostTeam();
        } else {
            return addGameDto.getOpponent();
        }
    }

    @Override
    public List<LeagueTableRow> leagueTable() {
        throw new RuntimeException("Not implemented yet");
    }
}
