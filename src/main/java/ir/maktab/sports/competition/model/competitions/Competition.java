package ir.maktab.sports.competition.model.competitions;

public class Competition {
    int hostTeamId;
    int opponentTeamId;
    int leagueId;
    int winnerID;

    public Competition(int hostTeamId, int opponentTeamId, int leagueId) {
        this.hostTeamId = hostTeamId;
        this.opponentTeamId = opponentTeamId;
        this.leagueId = leagueId;
    }

    public Competition(int hostTeamId, int opponentTeamId, int winnerID, int leagueId) {
        this.hostTeamId = hostTeamId;
        this.opponentTeamId = opponentTeamId;
        this.winnerID = winnerID;
        this.leagueId = leagueId;
    }

    public int getWinnerID() {
        return winnerID;
    }

    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }

    public int getHostTeamId() {
        return hostTeamId;
    }

    public void setHostTeamId(int hostTeamId) {
        this.hostTeamId = hostTeamId;
    }

    public int getOpponentTeamId() {
        return opponentTeamId;
    }

    public void setOpponentTeamId(int opponentTeamId) {
        this.opponentTeamId = opponentTeamId;
    }


    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }
}
