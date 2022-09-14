package ir.maktab.sports.competition.repository;

import ir.maktab.sports.competition.model.competitions.Competition;
import ir.maktab.sports.competition.model.dto.LeagueTableRow;
import ir.maktab.sports.competition.util.Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FootballGameRepository {

    public void saveGame(Competition competition) throws SQLException {
        String sql = "insert into t_games (hostteam_id,opponent_id,winner_id,league_id) values (?,?,?,?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, competition.getHostTeamId());
        preparedStatement.setInt(2, competition.getOpponentTeamId());
        preparedStatement.setInt(3, competition.getWinnerID());
        preparedStatement.setInt(4, competition.getLeagueId());
        preparedStatement.executeUpdate();
    }


    public void saveDrawGame(Competition competition) throws SQLException {
        String sql = "insert into t_games (hostteam_id,opponent_id,league_id) values (?,?,?)";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, competition.getHostTeamId());
        preparedStatement.setInt(2, competition.getOpponentTeamId());
        preparedStatement.setInt(3, competition.getLeagueId());
        preparedStatement.executeUpdate();
    }


    public List<LeagueTableRow> loadLeagueTableRows(List<Integer> teamIdList) {
        try {
            return doLoadLeagueTableRows(teamIdList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<LeagueTableRow> doLoadLeagueTableRows(List<Integer> teamIdList) throws SQLException {
        List<LeagueTableRow> result = new ArrayList<>();
        for (Integer teamId : teamIdList) {
            String teamName = calculateTeamName(teamId);
            int numOfGames = calculateNumOfGames(teamId);
            int numOfWins = calculateNumOfWins(teamId);
            int numOfLosses = calculateNumOfLosses(teamId);
            int numOfDraws = calculateNumOfDraws(teamId);
            int score = calculateScore(teamId);
            LeagueTableRow row = new LeagueTableRow(teamName, score, numOfGames, numOfWins, numOfLosses, numOfDraws);
            result.add(row);
        }
        return result;
    }

    private int calculateScore(int teamId) throws SQLException {
        String sql = "select score  from t_team tt where id=?;";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);

    }

    private int calculateNumOfDraws(int teamId) throws SQLException {
        String sql = "select count(*) from t_games tg where (opponent_id=? or hostteam_id=?) and winner_id is null;";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, teamId);
        preparedStatement.setInt(2, teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private int calculateNumOfLosses(int teamId) throws SQLException {
        String sql = "select count(*) from t_games tg where (opponent_id =? or hostteam_id =?) and (winner_id !=? and winner_id is not null);";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, teamId);
        preparedStatement.setInt(2, teamId);
        preparedStatement.setInt(3, teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);

    }

    private int calculateNumOfWins(int teamId) throws SQLException {
        String sql = "select count(*)  from t_games tg where winner_id = ?;";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);

    }

    private int calculateNumOfGames(int teamId) throws SQLException {
        String sql = "select count(*)  from t_games tg where hostteam_id = ? or opponent_id =?;";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, teamId);
        preparedStatement.setInt(2, teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private String calculateTeamName(int teamId) throws SQLException {
        String sql = "select name from t_team where id = ?";
        PreparedStatement preparedStatement = Application.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }
}
