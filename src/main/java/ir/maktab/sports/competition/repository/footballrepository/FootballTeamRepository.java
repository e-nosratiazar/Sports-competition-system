package ir.maktab.sports.competition.repository.footballrepository;

import ir.maktab.sports.competition.model.teams.FootballTeam;
import ir.maktab.sports.competition.util.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FootballTeamRepository {


    public void save(FootballTeam team) {
        try {
            doSave(team);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doSave(FootballTeam team) throws SQLException {
        String sql = "insert into t_team (league_id,name, nationality) values (?,?, ?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        preparedStatement.setString(2, team.getName());
        preparedStatement.setString(3, team.getNationality());

        preparedStatement.executeUpdate();
    }

    public List<FootballTeam> loadAllTeams() {
        try {
            return doLoadAllTeams();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<FootballTeam> doLoadAllTeams() throws SQLException {
        List<FootballTeam> result = new ArrayList<>();
        String sql = "select id, name, nationality from t_team";
        Statement statement = Application.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            FootballTeam footballTeam = new FootballTeam(id, name, nationality);
            result.add(footballTeam);
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
        String sql="delete from t_team where id=?";
        PreparedStatement preparedStatement=Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, i);
        return preparedStatement.executeUpdate();
    }


    public String showInformationById(int i) throws SQLException {
        String sql="select * from t_team where id=?";
        PreparedStatement preparedStatement=Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, i);
        ResultSet resultSet =preparedStatement.executeQuery();
        // TODO: 9/6/2022 :jadval team kamel shavad 
        return null;
    }
}
