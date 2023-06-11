package es.brouse.game.utils;

/**
 * Class used as a container to store all the stats of
 * the game such as points, time, win, username.
 */
public class GameStats {
    /*----------- PRIVATE ------------*/
    public static final int LENGTH = 72;
    private final int points;
    private final long time;
    private final boolean win;
    private final String username;

    /**
     * Main class constructor used to create new {@link GameStats}
     * instances.
     *
     * @param username player username
     * @param win win status
     * @param points points of game
     */
    public GameStats(String username, boolean win, int points) {
        this.username = username;
        this.time = System.currentTimeMillis();
        this.win = win;
        this.points = points;
    }

    /**
     * Class constructor used to create new {@link GameStats}
     * instances when is read form the file.
     *
     * @param username player username
     * @param win win status
     * @param points points of game
     */
    public GameStats(String username, long time, boolean win, int points) {
        this.username = username;
        this.time = time;
        this.win = win;
        this.points = points;
    }

    /**
     * Get the time.
     *
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * Get the win status
     *
     * @return the win status
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Get the points.
     *
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Get the denormalized username string name.
     *
     * @return the username with 32 chars length
     */
    public String getUsername() {
        if (username.length() > 32) return username.substring(0, 32);

        final String delimiter = String.valueOf(((char)0));
        StringBuilder builder = new StringBuilder(username);

        builder.append(delimiter.repeat(Math.max(0, 32 - builder.length())));

        return builder.toString();
    }

    /**
     * Get the raw username.
     *
     * @return the raw username
     */
    public String getRawUsername() {
        return normalize(username);
    }

    /**
     * Normalise the sting to remove the '0'chars.
     *
     * @param str text to normalize
     * @return the normalized string
     */
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
