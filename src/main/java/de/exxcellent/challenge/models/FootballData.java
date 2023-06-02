package de.exxcellent.challenge.models;

public class FootballData {
    private final String team;
    private final int games;
    private final int wins;
    private final int losses;
    private final int draws;
    private final int goals;
    private final int goalsAllowed;
    private final int points;

    public String getTeam() {
        return this.team;
    }

    public int getGoalSpread() {
        return Math.abs(this.goals - this.goalsAllowed);
    }

    public FootballData(String team, int games, int wins, int losses, int draws, int goals, int goalsAllowed, int points) {
        this.team = team;
        this.games = games;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
        this.points = points;
    }

    @Override
    public String toString() {
        return "FootballData{" +
                "team='" + team + '\'' +
                ", games=" + games +
                ", wins=" + wins +
                ", losses=" + losses +
                ", draws=" + draws +
                ", goals=" + goals +
                ", goalsAllowed=" + goalsAllowed +
                ", points=" + points +
                '}';
    }
}
