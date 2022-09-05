package ir.maktab.sports.competition.model.competitions;

import ir.maktab.sports.competition.model.teams.Team;

public class Competition {
    Team opponent;
    enum result{
        WINNER,LOSER;
    }

    public Competition(Team opponent) {
        this.opponent = opponent;
    }

}
