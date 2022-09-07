package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;

import java.util.List;

public class ShowInformationTeamView extends AbstractView {
    FootballTeamService footballTeamService = new FootballTeamService();

    public void showInformationTeamMenu() {
        List<FootballTeam> teams = footballTeamService.loadAllTeams();
        for (FootballTeam team : teams) {
            System.out.println("\t"+team);
        }
        System.out.println("enter id to show information : ");
        int i = Integer.parseInt(scanner.nextLine());
        FootballTeam result = footballTeamService.showInformationById(i);
        System.out.println(result);
    }


}
