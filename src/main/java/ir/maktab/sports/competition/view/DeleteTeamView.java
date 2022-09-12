package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballService;
import ir.maktab.sports.competition.service.VolleyballService;

import java.sql.SQLException;
import java.util.List;

public class DeleteTeamView extends AbstractView {

    FootballService footballService = new FootballService();
    VolleyballService volleyballService = new VolleyballService();

    public void deleteFootballTeamMenu() throws SQLException {
        List<FootballTeam> teams = footballService.loadAllFootballTeams();
        for (FootballTeam team : teams) {
            System.out.println("\t" + team);
        }
        System.out.println("enter team name to remove");
        String tameName = scanner.nextLine();
        String result = footballService.removeByName(tameName);
        System.out.println(result);
    }

    public void deleteVolleyballTeam() {
        List<VolleyballTeam> teams = volleyballService.loadAllVolleyballTeams();
        for (VolleyballTeam team :
                teams) {
            System.out.println("\t" + team);
        }
        System.out.println("enter id to remove");
        int i = Integer.parseInt(scanner.nextLine());
        String result = volleyballService.removeById(i);
        System.out.println(result);
    }
}
