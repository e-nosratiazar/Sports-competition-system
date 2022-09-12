package ir.maktab.sports.competition.repository.footballrepository;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.dto.AddGameDto;
import ir.maktab.sports.competition.util.Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FootballLeagueRepository {

    public void saveGame(Competition competition) throws SQLException {
        String sql = "insert into t_games (hostteam_id,opponent_id,winner_id,league_id) values (?,?,?,?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, competition.getHostTeamId());
        preparedStatement.setInt(2, competition.getOpponentTeamId());
        preparedStatement.setInt(3, competition.getWinnerID());
        preparedStatement.setInt(4,competition.getLeagueId());
        preparedStatement.executeUpdate();
    }



    public int findFootballLeagueId() throws SQLException {
        String sql = "select id from t_league where name = 'football'";
        PreparedStatement statement = Application.getConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public void saveDrawGame(Competition competition) throws SQLException {
        String sql="insert into t_games (hostteam_id,opponent_id,league_id) values (?,?,?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,competition.getHostTeamId());
        preparedStatement.setInt(2,competition.getOpponentTeamId());
        preparedStatement.setInt(3,competition.getLeagueId());
        preparedStatement.executeUpdate();
    }
}
