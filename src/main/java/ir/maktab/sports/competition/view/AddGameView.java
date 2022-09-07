package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballTeamService;
import ir.maktab.sports.competition.service.VolleyballTeamService;

import java.util.List;

public class AddGameView extends AbstractView {
    FootballTeamService footballTeamService = new FootballTeamService();
    VolleyballTeamService volleyballTeamService = new VolleyballTeamService();

    public void showAddVolleyballGameMenu() {
        List<VolleyballTeam> teams = volleyballTeamService.loadAllVolleyballTeams();
        for (VolleyballTeam team :
                teams) {
            System.out.println("\t" + team);
        }
        System.out.print("Enter host team id :");
        int hostTeamId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter opponent team id :");
        int opponentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter winner id (if the result of the game was a draw,enter 0) : ");
        int resultOfGame = Integer.parseInt(scanner.nextLine());
        Competition competition = new Competition(hostTeamId, opponentId, resultOfGame);
        String result = volleyballTeamService.addGame(competition);
        System.out.println("\n" + result + "\n");
    }
}
