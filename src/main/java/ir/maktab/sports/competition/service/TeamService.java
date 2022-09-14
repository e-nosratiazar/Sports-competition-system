package ir.maktab.sports.competition.service;

import ir.maktab.sports.competition.model.teams.Team;

public interface TeamService {
    String save(Team team);

    String removeByName(String name);

    Team showInformationByName(String name);
}
