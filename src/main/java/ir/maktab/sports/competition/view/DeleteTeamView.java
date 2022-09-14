package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;
import ir.maktab.sports.competition.service.VolleyballTeamService;

import java.sql.SQLException;
import java.util.List;

public class DeleteTeamView extends AbstractView {

    FootballTeamService footballTeamService = new FootballTeamService();
    VolleyballTeamService volleyballTeamService = new VolleyballTeamService();

    public void showFootballTeamDeleteMenu() throws SQLException {
        System.out.println("\n\t** remove football team **" +
                "\n\twhich one team do you want to remove?\n ");
        List<FootballTeam> teams = footballTeamService.loadAllFootballTeams();
        for (FootballTeam team : teams) {
            System.out.println("\t" + team);
        }
        System.out.print("enter team name to remove: ");
        String tameName = scanner.nextLine();
        String result = footballTeamService.removeByName(tameName);
        System.out.println("\n\t" + result);
    }

    public void deleteVolleyballTeam() {
        System.out.println("\n\t** remove volleyball team **" +
                "\n\twhich one team do you want to remove?\n ");
        List<VolleyballTeam> teams = volleyballTeamService.loadAllVolleyballTeams();
        for (VolleyballTeam team :
                teams) {
            System.out.println("\t" + team);
        }
        System.out.print("enter team name to remove : ");
        String tameName = scanner.nextLine();
        String result = volleyballTeamService.removeByName(tameName);
        System.out.println("\n\t" + result);
    }
}
