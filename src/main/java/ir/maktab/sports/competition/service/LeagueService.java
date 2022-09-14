package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.dto.LeagueTableRow;
import ir.maktab.sports.competition.model.teams.Team;

import java.util.List;

public interface LeagueService {
    public String save(Team team);
    public String removeByName(String name);
    public void addGame(AddGameDto addGameDto);
    public Team showInformationByName(String name);
    public List<LeagueTableRow> leagueTable();
}
