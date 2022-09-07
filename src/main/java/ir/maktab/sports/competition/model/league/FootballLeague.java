package ir.maktab.sports.competition.model.league;

import ir.maktab.sports.competition.model.Sports;
import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.Team;

import java.util.ArrayList;
import java.util.List;

public class FootballLeague extends league {
    Sports sport;
    List<FootballTeam> footballTeams;

    public FootballLeague(List<FootballTeam> footballTeams) {
        this.footballTeams = footballTeams;
        this.sport = Sports.FOOTBALL;
    }

    public List<FootballTeam> getFootballTeams() {
        return footballTeams;
    }

    public void setFootballTeams(List<FootballTeam> footballTeams) {
        this.footballTeams = footballTeams;
    }
}
