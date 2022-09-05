package ir.maktab.sports.competition.model.league;

import ir.maktab.sports.competition.model.teams.Team;

public interface league {
public void addTeam(Team team);
public void deleteTeam();
public void addGame();
public void showInformationOfTeam();
public void showTournamentTable();

}
