package ir.maktab.sports.competition.model.player;

import ir.maktab.sports.competition.model.Sports;
import ir.maktab.sports.competition.model.teams.Team;

public class Player {
    Sports sports;
    int id;
    String name;
    Team team;

    public Player(Sports sports, String name, Team team) {
        this.sports = sports;
        this.name = name;
        this.team = team;
    }

    public Sports getSports() {
        return sports;
    }

    public void setSports(Sports sports) {
        this.sports = sports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return
                "\tname = '" + name + '\'' +
                        "\tteam = " + team.getName();
    }
}
