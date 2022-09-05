package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;

public class AddTeamView extends AbstractView {

    private FootballTeamService footballTeamService = new FootballTeamService();

    public void showAddTeamMenu() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Nationality");
        String nationality = scanner.nextLine();
        FootballTeam team = new FootballTeam(name, nationality);
        String result = footballTeamService.save(team);
        System.out.println("\n" + result + "\n");
    }
}
