package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.dto.LeagueTableRow;
import ir.maktab.sports.competition.service.FootballGameService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShowLeagueTableView {
    FootballGameService footballGameService = new FootballGameService();

    public void showVolleyballLeagueTable() {
        throw new RuntimeException("Not Implemented yet");
    }

    public void showFootballLeagueTable() {
        System.out.println("\n\t** football league table **\n");
        List<LeagueTableRow> leagueTable = footballGameService.leagueTable();
        Collections.sort(leagueTable, Comparator.comparing(LeagueTableRow::getScore).reversed());
        System.out.println("Sco\tGms\tWin\tLos\tDrw\tName");
        for (LeagueTableRow row : leagueTable) {
            System.out.println(row);
        }
    }
}
