package ir.maktab.sports.competition.view;

import java.sql.SQLException;

public class FootballLeagueView extends AbstractView {

    public void showFootballLeagueMenu() throws SQLException {
        boolean stayInMenu = true;
        while (stayInMenu) {
            System.out.print("\t1 : add a team" +
                    "\n\t2 : delete a team" +
                    "\n\t3 : add game" +
                    "\n\t4 : show information of the team" +
                    "\n\t5 : show tournament table" +
                    "\n\t6 : back" +
                    "\nEnter your option : ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    AddTeamView addTeamView = new AddTeamView();
                    addTeamView.showAddFootballTeamMenu();
                    break;
                case 2:
                    DeleteTeamView deleteTeamView = new DeleteTeamView();
                    deleteTeamView.deleteFootballTeamMenu();
                    break;
                case 3:
                    AddGameView addGameView = new AddGameView();
                    addGameView.showAddFootballGameMenu();
                    break;
                case 4:
                    ShowInformationTeamView showInformationTeamView = new ShowInformationTeamView();
                    showInformationTeamView.showInformationFootballTeamMenu();
                    break;
                case 5: // TODO: 9/5/2022 show table
                    break;
                case 6:
                    stayInMenu = false;
                    break;
                default:
                    System.out.println("the entered number is invalid");
            }
        }
    }
}
