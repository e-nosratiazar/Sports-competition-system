package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;
import ir.maktab.sports.competition.service.VolleyballTeamService;

import java.sql.SQLException;
import java.util.List;

public class ShowTeamInformationView extends AbstractView {

    FootballTeamService footballTeamService = new FootballTeamService();
    VolleyballTeamService volleyballTeamService = new VolleyballTeamService();

    public void showFootballTeamInformationMenu() throws SQLException {
        System.out.println("\n\t** show information football team **" +
                "\n\tthere are these teams in football league\n");
        List<FootballTeam> teams = footballTeamService.loadAllFootballTeams();
        for (FootballTeam team : teams) {
            System.out.println("\t" + team);
        }
        System.out.print("\nenter team name display more information : ");
        String teamName = scanner.nextLine();
        FootballTeam result = footballTeamService.showInformationByName(teamName);
        System.out.println("\n\t" + result.details());
    }


    public void showInformationVolleyballTeamMenu() {
        System.out.println("\n\t** show information volleyball team **" +
                "\n\tthere are these teams in volleyball league\n");
        List<VolleyballTeam> teams = volleyballTeamService.loadAllVolleyballTeams();
        for (VolleyballTeam team : teams) {
            System.out.print("\t" + team);
        }
        System.out.println("\nenter team name display more information : ");
        String teamName = scanner.nextLine();
        VolleyballTeam result = volleyballTeamService.showInformationByName(teamName);
        System.out.println("\n\t" + result.details());
    }
}
