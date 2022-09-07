package ir.maktab.sports.competition.model.teams;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Team {
    String name;
    String nationality;
    int id;
    int score;
    List<Player> players = new ArrayList<>();
    List<Competition> competitionList = new ArrayList<>();

    public Team(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
        score = 0;
    }

    public Team(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public Team(String name, String nationality, List<Player> players, List<Competition> competitionList, int score) {
        this.name = name;
        this.nationality = nationality;
        this.players = players;
        this.competitionList = competitionList;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getScore() {
        return score;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }
}
