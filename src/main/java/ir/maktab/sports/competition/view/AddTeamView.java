package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballService;
import ir.maktab.sports.competition.service.VolleyballService;

public class AddTeamView extends AbstractView {

    private FootballService footballService = new FootballService();
    private VolleyballService volleyballService = new VolleyballService();

    public void showAddFootballTeamMenu() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Nationality");
        String nationality = scanner.nextLine();
        FootballTeam team = new FootballTeam(name, nationality);
        String result = footballService.save(team);
        System.out.println("\n" + result + "\n");
    }

    public void showAddVolleyballTeamMenu() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Nationality");
        String nationality = scanner.nextLine();
        VolleyballTeam team = new VolleyballTeam(name, nationality);
        String result = volleyballService.save(team);
        System.out.println("\n" + result + "\n");
    }
}
