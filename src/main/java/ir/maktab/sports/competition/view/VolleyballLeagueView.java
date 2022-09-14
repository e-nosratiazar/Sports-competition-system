package ir.maktab.sports.competition.view;

public class VolleyballLeagueView extends AbstractView {

    public void showVolleyballLeagueMenu() {
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
                    addTeamView.showAddVolleyballTeamMenu();
                    break;
                case 2:
                    DeleteTeamView deleteTeamView = new DeleteTeamView();
                    deleteTeamView.deleteVolleyballTeam();
                    break;
                case 3:
                    AddGameView addGameView = new AddGameView();
                    addGameView.showAddVolleyballGameMenu();
                    break;
                case 4:
                    ShowInformationTeamView showInformationTeamView = new ShowInformationTeamView();
                    showInformationTeamView.showInformationVolleyballTeamMenu();
                    break;
                case 5: // TODO: 9/5/2022 show table
                    ShowLeagueTableView showLeagueTableView = new ShowLeagueTableView();
                    showLeagueTableView.showVolleyballLeagueTable();
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
