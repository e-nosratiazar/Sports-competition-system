package ir.maktab.sports.competition.repository.volleyball.repository;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.model.teams.VolleyballTeam;
import ir.maktab.sports.competition.util.Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VolleyballTeamRepository {

    public void save(VolleyballTeam team) {
        try {
            doSave(team);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doSave(VolleyballTeam team) throws SQLException {
        String sql = "insert into t_team (league_id,name, nationality) values (?,?, ?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, team.getName());
        preparedStatement.setString(3, team.getNationality());
        preparedStatement.executeUpdate();
    }

    public List<VolleyballTeam> loadAllTeams() {
        try {
            return doLoadAllTeams();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<VolleyballTeam> doLoadAllTeams() throws SQLException {
        List<VolleyballTeam> result = new ArrayList<>();
        String sql = "select id, name, nationality from t_team where league_id=2";
        Statement statement = Application.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            VolleyballTeam volleyballTeam = new VolleyballTeam(id, name, nationality);
            result.add(volleyballTeam);
        }
        return result;
    }

    public int removeById(int i) {
        try {
            return doRemoveById(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int doRemoveById(int i) throws SQLException {
        String sql = "delete from t_team where id=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, i);
        return preparedStatement.executeUpdate();
    }

    public VolleyballTeam showInformationTeamById(int i) throws SQLException {
        VolleyballTeam volleyballTeam = null;
        String sql = "select name,nationality,score from t_team where id=?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, i);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String teamName = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            double score = resultSet.getDouble("score");
            volleyballTeam = new VolleyballTeam(i, teamName, nationality);
        }
        return volleyballTeam;
    }


}

