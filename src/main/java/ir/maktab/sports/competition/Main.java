package ir.maktab.sports.competition;

import ir.maktab.sports.competition.view.MainView;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.showMainView();
    }
}
