package ir.maktab.sports.competition.model.league;

import ir.maktab.sports.competition.model.Sports;
import ir.maktab.sports.competition.model.teams.Team;

import java.util.ArrayList;
import java.util.List;

public abstract class league {
    int id;
    Sports sport;
    List<Team> teams = new ArrayList<>();

}
