package es.brouse.game.utils;

public class GameStats {
    private final int moves;
    private final int minMoves;
    private final long startTime;
    private final long time;

    public GameStats(int moves, int minMoves, long startTime) {
        this.moves = moves;
        this.startTime = startTime;
        this.minMoves = minMoves;
        this.time = System.currentTimeMillis() - startTime;
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
}
