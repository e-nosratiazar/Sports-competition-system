package ir.maktab.sports.competition.view;

import java.sql.SQLException;

public class MainView extends AbstractView {


    public void showMainView() throws SQLException {
        boolean stayInMenu = true;
        while (stayInMenu) {
            System.out.print(
                    "\t1 : Football league \n"
                            + "\t2 : Volleyball league \n"
                            + "\t3 : Exit\n" +
                            "\nEnter your option : ");
            int chosenOption = Integer.parseInt(scanner.nextLine());
            switch (chosenOption) {
                case 1:
                    new FootballLeagueView().showFootballLeagueMenu();
                    break;
                case 2:
                    new VolleyballLeagueView().showVolleyballLeagueMenu();
                    break;
                case 3:
                    stayInMenu = false;
                    break;
                default:
                    System.out.println("\t**the entered number is invalid" +
                            " , try again**\n");
            }
        }
    }


}
