package ir.maktab.sports.competition.view;

import java.sql.SQLException;
import java.util.Scanner;

public class FootballLeagueView extends AbstractView {

    public void showFootballLeagueMenu() {
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
                    addTeamView.showAddTeamMenu();
                    break;
                case 2:
                    DeleteTeamView deleteTeamView = new DeleteTeamView();
                    deleteTeamView.deleteTeam();
                    break;
                case 3:
                    // TODO: 9/5/2022 add game method
                    break;
                case 4:
                    // TODO: 9/5/2022  show information team
                    ShowInformationTeamView showInformationTeamView=new ShowInformationTeamView();
                    showInformationTeamView.showInformationTeam();
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
