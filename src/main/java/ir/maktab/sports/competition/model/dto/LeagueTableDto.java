package ir.maktab.sports.competition.model.dto;

import ir.maktab.sports.competition.model.teams.Team;

public class LeagueTableDto {
    Team team;
    int numberOfGames;
    int numberOfWins;
    int numberOfLosses;
    int numberOfDraw;
    int score;

    public LeagueTableDto(Team team, int numberOfGames, int numberOfWins, int numberOfLosses, int numberOfDraw, int score) {
        this.team = team;
        this.numberOfGames = numberOfGames;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.numberOfDraw = numberOfDraw;
        this.score = score;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }

    public int getNumberOfDraw() {
        return numberOfDraw;
    }

    public void setNumberOfDraw(int numberOfDraw) {
        this.numberOfDraw = numberOfDraw;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
