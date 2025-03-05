package Generics;

public class User implements Comparable<User> {
    private int points;

    public User(int points) {
        this.points = points;
    }

    public int compareTo(User other) {
        // points < other.points -> -1 (-ve)
        // points == other.points -> 0
        // points > other.points -> 1 (+ve)

        return this.points - other.points;
    }

    @Override
    public String toString() {
        return "Points: " + points;
    }
}
