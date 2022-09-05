package ir.maktab.sports.competition.model.teams;

import ir.maktab.sports.competition.model.Sports;
import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.player.Player;

import java.util.List;

public class FootballTeam extends Team {
    Sports sport = Sports.FOOTBALL;

    public FootballTeam(String name, String nationality) {
        super(name, nationality);
    }

    public FootballTeam(int id, String name, String nationality) {
        super(id, name, nationality);
    }

    public FootballTeam(String name, String nationality, List<Player> players, List<Competition> competitionList, int score) {
        super(name, nationality, players, competitionList, score);
    }

    public Sports getSport() {
        return sport;
    }

    @Override
    public String toString() {
        return " id=" + id + "name='" + name + '\'' + ", nationality='" + nationality + '\'';
    }
}
