package ir.maktab.sports.competition;

import ir.maktab.sports.competition.view.MainView;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.showMainView();
    }

    private static void applicationServicesForVolleyballLeague(int chosenOptionC2) {
        switch (chosenOptionC2) {
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




}
