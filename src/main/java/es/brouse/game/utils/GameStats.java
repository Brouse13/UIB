package es.brouse.game.utils;

public class GameStats {
    public static final int LENGTH = 59;
    private final int moves, minMoves;
    private final long startTime, time;
    private final boolean win;
    private String username = "UNKNOWN";

    public GameStats(int moves, int minMoves, long startTime, boolean win) {
        this.moves = moves;
        this.startTime = startTime;
        this.minMoves = minMoves;
        this.time = System.currentTimeMillis() - startTime;
        this.win = win;
    }

    public GameStats(int moves, int minMoves, long startTime, long time, boolean win, String username) {
        this.moves = moves;
        this.minMoves = minMoves;
        this.startTime = startTime;
        this.time = time;
        this.win = win;
        this.username = username;
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

    public String getUsername() {
        StringBuilder builder = new StringBuilder(username);

        builder.append(" ".repeat(Math.max(0, 32 - builder.length())));

        return builder.toString();
    }

    public void setUsername(String username) {
        this.username = username;
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
