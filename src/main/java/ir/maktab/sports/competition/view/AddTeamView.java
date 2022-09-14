package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballService;
import ir.maktab.sports.competition.service.VolleyballService;

public class AddTeamView extends AbstractView {

    private FootballService footballService = new FootballService();
    private VolleyballService volleyballService = new VolleyballService();

    public void showAddFootballTeamMenu() {
        System.out.println("\n\t** add football team ** ");
        System.out.print("Enter team Name:");
        String name = scanner.nextLine();
        System.out.print("Enter Nationality:");
        String nationality = scanner.nextLine();
        FootballTeam team = new FootballTeam(name, nationality);
        String result = footballService.save(team);
        System.out.println("\n\t" + result );
    }

    public void showAddVolleyballTeamMenu() {
        System.out.println("\n\t** add volleyball team ** ");
        System.out.print("Enter Name:");
        String name = scanner.nextLine();
        System.out.print("Enter Nationality");
        String nationality = scanner.nextLine();
        VolleyballTeam team = new VolleyballTeam(name, nationality);
        String result = volleyballService.save(team);
        System.out.println("\n\t" + result );
    }
}
