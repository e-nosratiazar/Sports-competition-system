package ir.maktab.sports.competition.model.dto;

public class LeagueTableRow {
    String teamName;
    int numberOfGames;
    int numberOfWins;
    int numberOfLosses;
    int numberOfDraw;
    int score;

    public LeagueTableRow(String team, int score, int numberOfGames, int numberOfWins, int numberOfLosses, int numberOfDraw) {
        this.teamName = team;
        this.score = score;
        this.numberOfGames = numberOfGames;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.numberOfDraw = numberOfDraw;
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

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s", score, numberOfGames, numberOfWins, numberOfLosses, numberOfDraw, teamName);
    }
}
