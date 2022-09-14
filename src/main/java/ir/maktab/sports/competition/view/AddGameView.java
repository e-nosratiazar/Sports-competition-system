package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballGameService;
import ir.maktab.sports.competition.service.FootballTeamService;
import ir.maktab.sports.competition.service.VolleyballGameService;
import ir.maktab.sports.competition.service.VolleyballTeamService;

import java.sql.SQLException;
import java.util.List;

public class AddGameView extends AbstractView {
    VolleyballTeamService volleyballTeamService = new VolleyballTeamService();
    FootballTeamService footballTeamService = new FootballTeamService();
    FootballGameService footballGameService = new FootballGameService();
    VolleyballGameService volleyballGameService = new VolleyballGameService();

    public void showAddVolleyballGameMenu() {
        System.out.println("\n\t** add volleyball game **" +
                "\n\tthere are these teams in volleyball league\n");
        List<VolleyballTeam> teams = volleyballTeamService.loadAllVolleyballTeams();
        for (VolleyballTeam team :
                teams) {
            System.out.println("\t" + team);
        }
        System.out.print("Enter host team name :");
        String hostTeam = scanner.nextLine();
        System.out.print("Enter opponent team name :");
        String opponent = scanner.nextLine();
        System.out.print("How many sets has team " + hostTeam + " won : ");
        int hostSetsWon = Integer.parseInt(scanner.nextLine());
        System.out.print("How many sets has team " + opponent + " won : ");
        int opponentSetsWon = Integer.parseInt(scanner.nextLine());
        if ((hostSetsWon + opponentSetsWon) >= 3 && (hostSetsWon + opponentSetsWon) <= 5) {
            AddGameDto addGameDto = new AddGameDto(hostTeam, opponent, hostSetsWon, opponentSetsWon);
            volleyballGameService.addGame(addGameDto);
        } else {
            System.out.println("\t**the entered number is invalid" +
                    " , try again**\n");
        }
    }


    public void showFootballGameAdditionMenu() throws SQLException {
        System.out.println("\n\t** add football game **" +
                "\n\tthere are these teams in football league\n");
        List<FootballTeam> teams = footballTeamService.loadAllFootballTeams();
        for (FootballTeam team :
                teams) {
            System.out.println("\t" + team);
        }
        System.out.print("Enter host team name :");
        String hostTeam = scanner.nextLine();
        System.out.print("Enter opponent team name :");
        String opponent = scanner.nextLine();
        System.out.print("enter the number of goals for team " + hostTeam + " : ");
        int hostGoals = Integer.parseInt(scanner.nextLine());
        System.out.print("enter the number of goals for team " + opponent + " : ");
        int opponentGoals = Integer.parseInt(scanner.nextLine());
        AddGameDto addGameDto = new AddGameDto(hostTeam, opponent, hostGoals, opponentGoals);
        footballGameService.addGame(addGameDto);
    }
}
