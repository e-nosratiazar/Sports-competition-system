package ir.maktab.sports.competition.repository.footballrepository;

import ir.maktab.sports.competition.model.dto.ScoringDto;
import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.util.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FootballTeamRepository {


    public static int save(FootballTeam team, int leagueId) throws SQLException {
        String sql = "insert into t_team (league_id,name, nationality) values (?,?, ?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, leagueId);
        preparedStatement.setString(2, team.getName());
        preparedStatement.setString(3, team.getNationality());
        return preparedStatement.executeUpdate();
    }


    public static List<FootballTeam> loadAllTeams(int leagueId) throws SQLException {
        List<FootballTeam> result = new ArrayList<>();
        String sql = "select name, nationality from t_team where league_id=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, leagueId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            FootballTeam footballTeam = new FootballTeam(name, nationality);
            result.add(footballTeam);
        }
        return result;
    }


    public int removeByName(String teamName, int leagueId) throws SQLException {
        String sql = "delete from t_team where name=? and league_id=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, teamName);
        preparedStatement.setInt(2, leagueId);
        return preparedStatement.executeUpdate();
    }


    public FootballTeam showInformationTeamByName(String name) throws SQLException {
        FootballTeam footballTeam = null;
        String sql = "select name,nationality from t_team where name=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String teamName = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            footballTeam = new FootballTeam(teamName, nationality);
        }
        return footballTeam;
    }


    public int getIdByName(String team) throws SQLException {
        int teamId;
        String sql = "select id from t_team where name=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, team);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            teamId = resultSet.getInt("id");
            return teamId;
        }
        throw new RuntimeException("Team not found with name " + team);
    }

    public int getScoreByName(String teamName, int leagueId) throws SQLException {
        String sql = "select score from t_team where name=? and league_id=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, teamName);
        preparedStatement.setInt(2, leagueId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int score = resultSet.getInt("score");
            return score;
        }
        throw new RuntimeException("Team not found with name " + teamName);
    }

    public void updateScoreByName(ScoringDto scoringDto) throws SQLException {
        String sql = "update t_team set score=? where name =? and league_id=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, scoringDto.getScore());
        preparedStatement.setString(2, scoringDto.getTeamName());
        preparedStatement.setInt(3, scoringDto.getLeagueId());
        preparedStatement.executeUpdate();
    }
}
