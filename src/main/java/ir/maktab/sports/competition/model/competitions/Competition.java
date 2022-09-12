package ir.maktab.sports.competition.model.competitions;

import ir.maktab.sports.competition.model.teams.Team;

public class Competition {
    /*    Team hostTeam;
        Team opponent;
        enum result{
            DRAW,WINNER,LOSER;

        }
        public Competition(Team hostTeam, Team opponent) {
            this.hostTeam = hostTeam;
            this.opponent = opponent;
        }

        public Team getHostTeam() {
            return hostTeam;
        }

        public void setHostTeam(Team hostTeam) {
            this.hostTeam = hostTeam;
        }

        public Team getOpponent() {
            return opponent;
        }

        public void setOpponent(Team opponent) {
            this.opponent = opponent;
        }*/
    int hostTeamId;
    int opponentTeamId;
    int leagueId;
    int winnerID;
    enum result{
        DRAW,WIND_HOST,WIND_OPPONENT;
    }

    public Competition(int hostTeamId, int opponentTeamId, int leagueId) {
        this.hostTeamId = hostTeamId;
        this.opponentTeamId = opponentTeamId;
        this.leagueId = leagueId;
    }

    public Competition(int hostTeamId, int opponentTeamId, int winnerID, int leagueId) {
        this.hostTeamId = hostTeamId;
        this.opponentTeamId = opponentTeamId;
        this.winnerID=winnerID;
        this.leagueId=leagueId;
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
