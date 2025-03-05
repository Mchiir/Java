package Streams.Intermediate_Terminal;

public class Movie implements Comparable<Movie>{
    private String title;
    private int likes;

    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }
    @Override
    public String toString() {
        return this.title;
    }

    public String getTitle() { return this.title; }
    public int getLikes() { return this.likes; }

    @Override
    public int compareTo(Movie o) {
        return 0;
    }
}
