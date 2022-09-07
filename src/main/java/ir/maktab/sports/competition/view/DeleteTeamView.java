package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;
import ir.maktab.sports.competition.service.VolleyballTeamService;

import java.util.List;

public class DeleteTeamView extends AbstractView {

    FootballTeamService footballTeamService = new FootballTeamService();
    VolleyballTeamService volleyballTeamService = new VolleyballTeamService();

    public void deleteFootballTeamMenu() {
        List<FootballTeam> teams = footballTeamService.loadAllFootballTeams();
        for (FootballTeam team : teams) {
            System.out.println("\t" + team);
        }
        System.out.println("enter id to remove");
        int i = Integer.parseInt(scanner.nextLine());
        String result = footballTeamService.removeById(i);
        System.out.println(result);
    }

    public void deleteVolleyballTeam() {
        List<VolleyballTeam> teams = volleyballTeamService.loadAllVolleyballTeams();
        for (VolleyballTeam team :
                teams) {
            System.out.println("\t" + team);
        }
        System.out.println("enter id to remove");
        int i = Integer.parseInt(scanner.nextLine());
        String result = volleyballTeamService.removeById(i);
        System.out.println(result);
    }
}
