package ir.maktab.sports.competition.model.league;

import ir.maktab.sports.competition.model.Sports;
import ir.maktab.sports.competition.model.teams.Team;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;

import java.util.List;

public class VolleyballLeague extends league {
    Sports sport;
    List<VolleyballTeam> volleyballTeams;

    public VolleyballLeague( List<VolleyballTeam> volleyballTeams) {
        this.volleyballTeams = volleyballTeams;
        this.sport =Sports.VOLLEYBALL;
    }

    public List<VolleyballTeam> getVolleyballTeams() {
        return volleyballTeams;
    }

    public void setVolleyballTeams(List<VolleyballTeam> volleyballTeams) {
        this.volleyballTeams = volleyballTeams;
    }
}
