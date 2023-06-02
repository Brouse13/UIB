package es.brouse.game.utils;

public class GameStats {
    public static final int LENGTH = 61;
    private final int moves, minMoves, points;
    private final long startTime, time;
    private final boolean win;
    private String username = "UNKNOWN";

    public GameStats(int moves, int minMoves, long startTime, boolean win, int points) {
        this.moves = moves;
        this.startTime = startTime;
        this.minMoves = minMoves;
        this.time = System.currentTimeMillis() - startTime;
        this.win = win;
        this.points = points;
    }

    public GameStats(int moves, int minMoves, long startTime, long time, boolean win, int points, String username) {
        this.moves = moves;
        this.minMoves = minMoves;
        this.startTime = startTime;
        this.time = time;
        this.win = win;
        this.points = points;
        this.username = normalize(username);
    }

    public int getMoves() {
        return moves;
    }

    public int getMinMoves() {
        return minMoves;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getTime() {
        return time;
    }

    public boolean isWin() {
        return win;
    }

    public int getPoints() {
        return points;
    }

    public String getUsername() {
        final String delimiter = String.valueOf(((char)0));
        StringBuilder builder = new StringBuilder(username);

        builder.append(delimiter.repeat(Math.max(0, 32 - builder.length())));

        return builder.toString();
    }

    public String getRawUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String normalize(String str) {
        return str.split(String.valueOf(((char)0)))[0];
    }
    @Override
    public String toString() {
        return "GameStats{" +
                "moves=" + moves +
                ", minMoves=" + minMoves +
                ", startTime=" + startTime +
                ", time=" + time +
                ", win=" + win +
                ", username='" + username + '\'' +
                '}';
    }
}
