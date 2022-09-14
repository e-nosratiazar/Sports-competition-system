package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.dto.LeagueTableRow;

import java.util.List;

public interface GameService {
    void addGame(AddGameDto addGameDto);

    List<LeagueTableRow> leagueTable();
}
