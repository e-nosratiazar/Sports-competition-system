package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;
import ir.maktab.sports.competition.service.VolleyballTeamService;

public class AddTeamView extends AbstractView {

    private FootballTeamService footballTeamService = new FootballTeamService();
    private VolleyballTeamService volleyballTeamService = new VolleyballTeamService();

    public void showAddFootballTeamMenu() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Nationality");
        String nationality = scanner.nextLine();
        FootballTeam team = new FootballTeam(name, nationality);
        String result = footballTeamService.save(team);
        System.out.println("\n" + result + "\n");
    }

    public void showAddVolleyballTeamMenu() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Nationality");
        String nationality = scanner.nextLine();
        VolleyballTeam team = new VolleyballTeam(name, nationality);
        String result = volleyballTeamService.save(team);
        System.out.println("\n" + result + "\n");
    }
}
