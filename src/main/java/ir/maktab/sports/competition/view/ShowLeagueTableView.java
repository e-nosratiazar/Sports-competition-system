package ir.maktab.sports.competition.view;

import ir.maktab.sports.competition.model.dto.LeagueTableDto;
import ir.maktab.sports.competition.service.FootballService;
import ir.maktab.sports.competition.service.VolleyballService;

import java.util.List;

public class ShowLeagueTableView {
    FootballService footballService = new FootballService();
    VolleyballService volleyballService = new VolleyballService();

    public void showVolleyballLeagueTable() {


    }

    public void showFootballLeagueTable() {
        System.out.println("\n\t** football league table **\n");
        List<LeagueTableDto> leagueTable=footballService.footballLeagueTable();

    }
}
