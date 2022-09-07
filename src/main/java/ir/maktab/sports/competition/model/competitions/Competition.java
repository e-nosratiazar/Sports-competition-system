package ir.maktab.sports.competition.model.competitions;

import ir.maktab.sports.competition.model.teams.Team;

public class Competition {
    Team hostTeam;
    Team opponent;
    enum result{
        DRAW,WINNER,LOSER;
    }

    public Competition(Team hostTeam, Team opponent) {
        this.hostTeam = hostTeam;
        this.opponent = opponent;
    }
}
