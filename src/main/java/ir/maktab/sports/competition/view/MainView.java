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
                            "Enter your option : ");
            int chosenOption = Integer.parseInt(scanner.nextLine());
            switch (chosenOption) {
                case 1:
                    FootballLeagueView footballLeagueView = new FootballLeagueView();
                    footballLeagueView.showFootballLeagueMenu();
                    break;
                case 2:
                    VolleyballLeagueView volleyballLeagueView = new VolleyballLeagueView();
                    volleyballLeagueView.showVolleyballLeagueMenu();
                    break;
                case 3:
                    stayInMenu = false;
                    break;
                default:
                    System.out.println("the entered number is invalid");
            }
        }
    }


}
