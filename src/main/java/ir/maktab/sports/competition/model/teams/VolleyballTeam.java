package ir.maktab.sports.competition.model.teams;

import ir.maktab.sports.competition.model.Sports;
import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.player.Player;

import java.util.List;

public class VolleyballTeam extends Team {
    Sports sport = Sports.VOLLEYBALL;

    public VolleyballTeam(String name, String nationality) {
        super(name, nationality);
    }

    public VolleyballTeam(int id, String name, String nationality) {
        super(id, name, nationality);
    }

    public VolleyballTeam(String name, String nationality, List<Player> players, List<Competition> competitionList, int score) {
        super(name, nationality, players, competitionList, score);
    }

    public Sports getSport() {
        return sport;
    }

    @Override
    public String toString() {
        return "\tid = " + id + "\tname = '" + name + '\'' + "\tnationality = '" + nationality + '\'';
    }

    public String details() {
        return "\tid = " + id +
                "\tname = '" + name + '\'' +
                "\tnationality = '" + nationality + '\'' +
                "\tscore = " + score +
                "\n\tplayers: " + players;
    }
}
