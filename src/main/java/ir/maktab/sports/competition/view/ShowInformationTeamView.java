package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;
import ir.maktab.sports.competition.service.VolleyballTeamService;

import java.util.List;

public class ShowInformationTeamView extends AbstractView {
    FootballTeamService footballTeamService = new FootballTeamService();
    VolleyballTeamService volleyballTeamService = new VolleyballTeamService();

    public void showInformationFootballTeamMenu() {
        List<FootballTeam> teams = footballTeamService.loadAllFootballTeams();
        for (FootballTeam team : teams) {
            System.out.println("\t" + team);
        }
        System.out.println("enter id to show information : ");
        int i = Integer.parseInt(scanner.nextLine());
        FootballTeam result = footballTeamService.showInformationById(i);
        System.out.println(result);
    }


    public void showInformationVolleyballTeamMenu() {
        List<VolleyballTeam> teams = volleyballTeamService.loadAllVolleyballTeams();
        for (VolleyballTeam team : teams) {
            System.out.println("\t" + team);
        }
        System.out.println("enter id to show information : ");
        int i = Integer.parseInt(scanner.nextLine());
        VolleyballTeam result = volleyballTeamService.showInformationById(i);
        System.out.println(result);
    }
}