package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.repository.volleyball.repository.VolleyballLeagueRepository;
import ir.maktab.sports.competition.repository.volleyball.repository.VolleyballTeamRepository;

import java.sql.SQLException;
import java.util.List;

public class VolleyballService {

    VolleyballTeamRepository volleyballTeamRepository = new VolleyballTeamRepository();
    VolleyballLeagueRepository volleyballLeagueRepository = new VolleyballLeagueRepository();

    public String save(VolleyballTeam team) {
        try {
            volleyballTeamRepository.save(team);
            return "saved successfully";
        } catch (Exception e) {
            return "Error while saving team";
        }
    }

    public List<VolleyballTeam> loadAllVolleyballTeams()  {
        int leagueId=volleyballLeagueRepository.findVolleyballLeagueId();
        try {
            return volleyballTeamRepository.loadAllTeams(leagueId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String removeById(int i) {
        try {
            int num = volleyballTeamRepository.removeById(i);
            if (num == 1) {
                return "removed successfully";
            } else {
                return "failed to remove";
            }
        } catch (Exception e) {
            return "failed to remove";
        }

    }

    public VolleyballTeam showInformationById(int i) {
        try {
            return volleyballTeamRepository.showInformationTeamById(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


//    public String addGame(AddGameDto addGameDto) {
//        try {
//            int leagueId=volleyballLeagueRepository.findVolleyballLeagueId();
//            int hostTeamId = footballTeamRepository.getIdByName(addGameDto.getHostTeam());
//            int opponentTeamId = footballTeamRepository.getIdByName(addGameDto.getOpponent());
//            int winnerId;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return "save game is not successful";
//    }
}
