package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.service.FootballService;
import ir.maktab.sports.competition.service.VolleyballService;

import java.sql.SQLException;
import java.util.List;

public class AddGameView extends AbstractView {
    FootballService footballService = new FootballService();

    VolleyballService volleyballService = new VolleyballService();

    public void showAddVolleyballGameMenu() {
        List<VolleyballTeam> teams = volleyballService.loadAllVolleyballTeams();
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
            try {
                volleyballService.addGame(addGameDto);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("The entered numbers are invalid");
        }
    }


    public void showAddFootballGameMenu() throws SQLException {
        List<FootballTeam> teams = footballService.loadAllFootballTeams();
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
        footballService.addGame(addGameDto);
    }
}
