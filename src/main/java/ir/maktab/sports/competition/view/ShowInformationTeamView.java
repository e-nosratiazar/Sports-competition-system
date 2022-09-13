package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballService;
import ir.maktab.sports.competition.service.VolleyballService;

import java.sql.SQLException;
import java.util.List;

public class ShowInformationTeamView extends AbstractView {

    FootballService footballService = new FootballService();
    VolleyballService volleyballService = new VolleyballService();

    public void showInformationFootballTeamMenu() throws SQLException {
        List<FootballTeam> teams = footballService.loadAllFootballTeams();
        for (FootballTeam team : teams) {
            System.out.println("\t" + team);
        }
        System.out.println("enter team name to show information : ");
        String teamName = scanner.nextLine();
        FootballTeam result = footballService.showInformationByName(teamName);
        System.out.println(result);
    }


    public void showInformationVolleyballTeamMenu() {
        List<VolleyballTeam> teams = volleyballService.loadAllVolleyballTeams();
        for (VolleyballTeam team : teams) {
            System.out.println("\t" + team);
        }
        System.out.println("enter name to show information : ");
        String teamName = scanner.nextLine();
        VolleyballTeam result = volleyballService.showInformationByName(teamName);
        System.out.println(result.details());
    }
}
