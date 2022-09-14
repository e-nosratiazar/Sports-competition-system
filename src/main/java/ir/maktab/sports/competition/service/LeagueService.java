package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.model.dto.LeagueTableDto;
import ir.maktab.sports.competition.model.teams.Team;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;

import java.util.List;

public interface LeagueService {
    public String save(Team team);
    public String removeByName(String name);
    public void addGame(AddGameDto addGameDto);
    public Team showInformationByName(String name);
    public List<LeagueTableDto> leagueTable();
}
