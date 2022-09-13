package ir.maktab.sports.competition.model.dto;

public class ScoringDto {
    String teamName;
    int score;
    int leagueId;

    public ScoringDto(String teamName, int score, int leagueId) {
        this.teamName = teamName;
        this.score = score;
        this.leagueId = leagueId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public String toString() {
        return "ScoringDto{" +
                "teamName='" + teamName + '\'' +
                ", score=" + score +
                ", leagueId=" + leagueId +
                '}';
    }
}
