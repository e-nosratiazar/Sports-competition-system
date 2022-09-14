package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.teams.Team;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.repository.LeagueRepository;
import ir.maktab.sports.competition.repository.VolleyballTeamRepository;

import java.sql.SQLException;
import java.util.List;

public class VolleyballTeamService implements TeamService {

    VolleyballTeamRepository volleyballTeamRepository = new VolleyballTeamRepository();
    LeagueRepository leagueRepository = new LeagueRepository();

    @Override
    public String save(Team team) {
        try {
            volleyballTeamRepository.save(team);
            return "saved successfully";
        } catch (Exception e) {
            return "Error while saving team";
        }
    }

    public List<VolleyballTeam> loadAllVolleyballTeams() {
        try {
            int leagueId = leagueRepository.findVolleyballLeagueId();
            return volleyballTeamRepository.loadAllTeams(leagueId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String removeByName(String name) {
        try {
            int leagueId = leagueRepository.findVolleyballLeagueId();
            int num = volleyballTeamRepository.removeByName(name, leagueId);
            if (num == 1) {
                return "removed successfully";
            } else {
                return "failed to remove";
            }
        } catch (Exception e) {
            return "failed to remove";
        }

    }

    public VolleyballTeam showInformationByName(String name) {
        try {
            return volleyballTeamRepository.showInformationTeamByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
