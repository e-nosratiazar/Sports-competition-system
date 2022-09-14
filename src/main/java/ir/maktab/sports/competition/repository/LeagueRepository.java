package ir.maktab.sports.competition.repository;

import ir.maktab.sports.competition.util.Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeagueRepository {

    public int findFootballLeagueId() {
        try {
            return doFindFootballLeagueId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int doFindFootballLeagueId() throws SQLException {
        String sql = "select id from t_league where name = 'football'";
        PreparedStatement statement = Application.getConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public int findVolleyballLeagueId() {
        try {
            return doFindVolleyballLeagueId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int doFindVolleyballLeagueId() throws SQLException {
        String sql = "select id from t_league where name = 'volleyball'";
        PreparedStatement statement = Application.getConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

}
