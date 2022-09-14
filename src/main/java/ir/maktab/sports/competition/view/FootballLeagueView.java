package ir.maktab.sports.competition.view;

import java.sql.SQLException;

public class FootballLeagueView extends AbstractView {

    public void showFootballLeagueMenu() throws SQLException {
        boolean stayInMenu = true;
        while (stayInMenu) {
            System.out.print("\n\t**you are in football league**" +
                    "\n\t1 : add a team" +
                    "\n\t2 : delete a team" +
                    "\n\t3 : add game" +
                    "\n\t4 : show information of the team" +
                    "\n\t5 : show tournament table" +
                    "\n\t6 : back" +
                    "\nEnter your option : ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    new AddTeamView().showFootballTeamAdditionMenu();
                    break;
                case 2:
                    new DeleteTeamView().showFootballTeamDeleteMenu();
                    break;
                case 3:
                    new AddGameView().showFootballGameAdditionMenu();
                    break;
                case 4:
                    new ShowTeamInformationView().showFootballTeamInformationMenu();
                    break;
                case 5:
                    new ShowLeagueTableView().showFootballLeagueTable();
                    break;
                case 6:
                    stayInMenu = false;
                    break;
                default:
                    System.out.println("\t**the entered number is invalid" +
                            " , try again**\n");
            }
        }
    }
}
