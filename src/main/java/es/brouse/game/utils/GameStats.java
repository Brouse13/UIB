package es.brouse.game.utils;

public class GameStats {
    private final int moves;
    private final int minMoves;
    private final long startTime;
    private final long time;
    private final boolean win;
    private String username = "UNKNOWN";

    public GameStats(int moves, int minMoves, long startTime, boolean win) {
        this.moves = moves;
        this.startTime = startTime;
        this.minMoves = minMoves;
        this.time = System.currentTimeMillis() - startTime;
        this.win = win;
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

    public void setUsername(String username) {
        this.username = username;
    }
}
