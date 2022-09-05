package ir.maktab.sports.competition;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print(
                "1 : Football league " +
                        "\t2 : Volleyball league " + "\nenter your option : ");
        int chosenOption = Integer.parseInt(scanner.nextLine());
        switch (chosenOption) {
            case 1:
                int chosenOptionC1 = applicationServicesForEachLeague();
                applicationServicesForFootballLeague(chosenOptionC1);
                break;
            case 2:
                // TODO: 9/5/2022
                int chosenOptionC2 = applicationServicesForEachLeague();
                applicationServicesForVolleyballLeague(chosenOptionC2);
                break;
            default:
                System.out.println("the entered number is invalid");
        }
    }

    private static void applicationServicesForVolleyballLeague(int chosenOptionC2) {
        switch (chosenOptionC2){
            case 1:
                // TODO: 9/5/2022 add team method
                break;
            case 2:
                // TODO: 9/5/2022 delete team method
                break;
            case 3:
                // TODO: 9/5/2022 add game method
                break;
            case 4:
                // TODO: 9/5/2022  show information team
                break;
            case 5: // TODO: 9/5/2022 show table
                break;
            default:
                System.out.println("the entered number is invalid");
        }
    }

    private static void applicationServicesForFootballLeague(int chosenOptionC1) {
        switch (chosenOptionC1){
            case 1:
                // TODO: 9/5/2022 add team method
                break;
            case 2:
                // TODO: 9/5/2022 delete team method
                break;
            case 3:
                // TODO: 9/5/2022 add game method
                break;
            case 4:
                // TODO: 9/5/2022  show information team
                break;
            case 5: // TODO: 9/5/2022 show table
                break;
            default:
                System.out.println("the entered number is invalid");
        }
    }

    private static int applicationServicesForEachLeague() {
        System.out.print("1 : add a team" +
                "\n2 : delete a team" +
                "\n3 : add game" +
                "\n4 : show information of the team" +
                "\n5 : show tournament table" +
                "\nenter your option : ");
        return Integer.parseInt(scanner.nextLine());
    }
}
