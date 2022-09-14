package ir.maktab.sports.competition.model.dto;

import ir.maktab.sports.competition.model.teams.Team;

public class LeagueTableDto {
    String teamName;
    int numberOfGames;
    int numberOfWins;
    int numberOfLosses;
    int numberOfDraw;
    int score;
    int leagueId;

    public LeagueTableDto(String team, int numberOfGames, int numberOfWins, int numberOfLosses, int numberOfDraw, int score,int leagueId) {
        this.teamName = team;
        this.numberOfGames = numberOfGames;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.numberOfDraw = numberOfDraw;
        this.score = score;
        this.leagueId=leagueId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }
}
