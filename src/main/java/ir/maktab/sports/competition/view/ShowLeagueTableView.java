package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.dto.LeagueTableRow;
import ir.maktab.sports.competition.service.FootballService;
import ir.maktab.sports.competition.service.VolleyballService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShowLeagueTableView {
    FootballService footballService = new FootballService();
    VolleyballService volleyballService = new VolleyballService();

    public void showVolleyballLeagueTable() {


    }

    public void showFootballLeagueTable() {
        System.out.println("\n\t** football league table **\n");
        List<LeagueTableRow> leagueTable=footballService.footballLeagueTable();
        Collections.sort(leagueTable, Comparator.comparing(LeagueTableRow::getScore).reversed());
        System.out.println("Sco\tGms\tWin\tLos\tDrw\tName");
        for (LeagueTableRow row : leagueTable) {
            System.out.println(row);
        }
    }
}
