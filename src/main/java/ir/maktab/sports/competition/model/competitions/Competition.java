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
    int winnerId;   //winnerId=0 --> result Of game was draw

    public Competition(int hostTeamId, int opponentTeamId) {
        this.hostTeamId = hostTeamId;
        this.opponentTeamId = opponentTeamId;
    }

    public Competition(int hostTeamId, int opponentTeamId, int winnerId) {
        this.hostTeamId = hostTeamId;
        this.opponentTeamId = opponentTeamId;
        this.winnerId = winnerId;
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

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

}
