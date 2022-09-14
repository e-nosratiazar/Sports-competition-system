package ir.maktab.sports.competition.repository;

import ir.maktab.sports.competition.model.dto.ScoringDto;
import ir.maktab.sports.competition.model.teams.Team;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.util.Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VolleyballTeamRepository {

    public void save(Team team) {
        try {
            doSave(team);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doSave(Team team) throws SQLException {
        String sql = "insert into t_team (league_id,name, nationality) values (?,?, ?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, team.getName());
        preparedStatement.setString(3, team.getNationality());
        preparedStatement.executeUpdate();
    }


    public List<VolleyballTeam> loadAllTeams(int leagueId) throws SQLException {
        List<VolleyballTeam> volleyballTeams = new ArrayList<>();
        String sql = "select  name, nationality from t_team where league_id=?";
        PreparedStatement statement = Application.getConnection().prepareStatement(sql);
        statement.setInt(1, leagueId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            VolleyballTeam volleyballTeam = new VolleyballTeam(name, nationality);
            volleyballTeams.add(volleyballTeam);
        }
        return volleyballTeams;
    }


    public int removeByName(String name, int leagueId) throws SQLException {
        String sql = "delete from t_team where name=? and  league_id=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, leagueId);
        return preparedStatement.executeUpdate();
    }

    public VolleyballTeam showInformationTeamByName(String name) throws SQLException {
        VolleyballTeam volleyballTeam = null;
        String sql = "select name,nationality,score from t_team where name=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String teamName = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            int score = resultSet.getInt("score");
            volleyballTeam = new VolleyballTeam(teamName, nationality, score);
        }
        return volleyballTeam;
    }


    public int getIdByName(String team) throws SQLException {
        int id;
        String sql = "select id from t_team where name=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, team);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("id");
            return id;
        }
        throw new RuntimeException("Team not found with name " + team);
    }

    public int getScoreByName(String team) throws SQLException {
        int score;
        String sql = "select score from t_team where name=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, team);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            score = resultSet.getInt("score");
            return score;
        }
        throw new RuntimeException("Team not found with name " + team);
    }

    public void updateScoresByTeamNames(ScoringDto scoringDto) throws SQLException {
        String sql = "update t_team set score=? where name =? and league_id=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, scoringDto.getScore());
        preparedStatement.setString(2, scoringDto.getTeamName());
        preparedStatement.setInt(3, scoringDto.getLeagueId());
        preparedStatement.executeUpdate();
    }
}

