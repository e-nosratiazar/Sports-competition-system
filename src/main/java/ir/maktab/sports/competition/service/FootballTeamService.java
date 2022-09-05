package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.repository.footballrepository.FootballTeamRepository;

import java.util.List;

public class FootballTeamService {

    FootballTeamRepository footballTeamRepository = new FootballTeamRepository();
    public String save(FootballTeam team) {
        try {
            footballTeamRepository.save(team);
            return "saved successfully";
        } catch (Exception e){
            return "Error while saving team";
        }
    }

    public List<FootballTeam> loadAllTeams() {
        return footballTeamRepository.loadAllTeams();
    }

    public String removeById(int i) {
        int num =  footballTeamRepository.removeById(i);
        if(num ==1){
            return "removed successfully";
        }else {
            return "failed to remove";
        }
    }
}
