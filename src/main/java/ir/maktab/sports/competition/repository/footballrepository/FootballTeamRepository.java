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
        String sql = "insert into t_team (name, nationality) values (?, ?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, team.getName());
        preparedStatement.setString(2, team.getNationality());
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
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            FootballTeam footballTeam = new FootballTeam(id, name, nationality);
            result.add(footballTeam);
        }
        return result;
    }

    public int removeById(int i) {
        return 1;
    }
    // TODO: 9/5/2022  add team method & delete team method & show information team

}
