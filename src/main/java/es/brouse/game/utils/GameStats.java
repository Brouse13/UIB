package es.brouse.game.utils;

public class GameStats {
    public static final int LENGTH = 72;
    private final int points;
    private final long time;
    private final boolean win;
    private final String username;

    public GameStats(String username, boolean win, int points) {
        this.username = username;
        this.time = System.currentTimeMillis();
        this.win = win;
        this.points = points;
    }

    public GameStats(String username, long time, boolean win, int points) {
        this.username = username;
        this.time = time;
        this.win = win;
        this.points = points;
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
        if (username.length() > 32) return username.substring(0, 32);

        final String delimiter = String.valueOf(((char)0));
        StringBuilder builder = new StringBuilder(username);

        builder.append(delimiter.repeat(Math.max(0, 32 - builder.length())));

        return builder.toString();
    }

    public String getRawUsername() {
        return normalize(username);
    }

    private String normalize(String str) {
        return str.split(String.valueOf(((char)0)))[0];
    }

    @Override
    public String toString() {
        return "GameStats{" +
                "points=" + points +
                ", time=" + time +
                ", win=" + win +
                ", username='" + username + '\'' +
                '}';
    }
}
