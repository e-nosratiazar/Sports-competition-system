package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.repository.footballrepository.FootballTeamRepository;

import java.sql.SQLException;
import java.util.List;

public class FootballTeamService {

    FootballTeamRepository footballTeamRepository = new FootballTeamRepository();

    public String save(FootballTeam team) {
        try {
            footballTeamRepository.save(team);
            return "saved successfully";
        } catch (Exception e) {
            return "Error while saving team";
        }
    }

    public List<FootballTeam> loadAllTeams() {
        return footballTeamRepository.loadAllTeams();
    }

    public String removeById(int i) {
        try {
            int num = footballTeamRepository.removeById(i);
            if (num == 1) {
                return "removed successfully";
            } else {
                return "failed to remove";
            }
        }catch (Exception e){
            return "failed to remove";
        }
    }

    public String showInformationById(int i) {
        return footballTeamRepository.showInformationById(i);
    }
}
