package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.Team;
import ir.maktab.sports.competition.repository.FootballTeamRepository;
import ir.maktab.sports.competition.repository.LeagueRepository;

import java.sql.SQLException;
import java.util.List;

public class FootballTeamService implements TeamService {

    FootballTeamRepository footballTeamRepository = new FootballTeamRepository();
    private LeagueRepository footballLeagueRepository = new LeagueRepository();

    @Override
    public String save(Team team) {
        try {
            int footballLeagueId = footballLeagueRepository.findFootballLeagueId();
            int num = footballTeamRepository.save(team, footballLeagueId);
            if (num == 1) {
                return "saved successfully";
            } else {
                return "Error while saving team";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<FootballTeam> loadAllFootballTeams() throws SQLException {
        int footballLeagueId = footballLeagueRepository.findFootballLeagueId();
        return footballTeamRepository.loadAllTeams(footballLeagueId);
    }

    @Override
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

    @Override
    public FootballTeam showInformationByName(String teamName) {
        try {
            return footballTeamRepository.showInformationTeamByName(teamName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
