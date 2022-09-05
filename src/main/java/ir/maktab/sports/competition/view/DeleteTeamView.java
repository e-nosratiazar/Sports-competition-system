package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;

import java.util.List;

public class DeleteTeamView extends AbstractView {

    FootballTeamService footballTeamService = new FootballTeamService();
    public void deleteTeam() {
        List<FootballTeam> teams = footballTeamService.loadAllTeams();
        for (FootballTeam team : teams) {
            System.out.println("\t"+team);
        }
        System.out.println("enter id to remove");
        int i = Integer.parseInt(scanner.nextLine());
        String result = footballTeamService.removeById(i);
        System.out.println(result);
    }
}
