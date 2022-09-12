package ir.maktab.sports.competition.model.dto;

public class AddGameDto {
    String hostTeam;
    String opponent;
    int hostTeamGoals;
    int opponentGoals;

    public AddGameDto(String hostTeam, String opponent, int hostTeamGoals, int opponentGoals) {
        this.hostTeam = hostTeam;
        this.opponent = opponent;
        this.hostTeamGoals = hostTeamGoals;
        this.opponentGoals = opponentGoals;
    }

    public String getHostTeam() {
        return hostTeam;
    }

    public void setHostTeam(String hostTeam) {
        this.hostTeam = hostTeam;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public int getHostTeamGoals() {
        return hostTeamGoals;
    }

    public void setHostTeamGoals(int hostTeamGoals) {
        this.hostTeamGoals = hostTeamGoals;
    }

    public int getOpponentGoals() {
        return opponentGoals;
    }

    public void setOpponentGoals(int opponentGoals) {
        this.opponentGoals = opponentGoals;
    }
}
