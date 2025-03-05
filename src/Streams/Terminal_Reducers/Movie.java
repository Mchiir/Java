package Streams.Terminal_Reducers;

public class Movie implements Comparable<Movie>{
    private String title;
    private int likes;
    private Genre genre;

    public Movie(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }
    @Override
    public String toString() {
        return this.title;
    }

    public String getTitle() { return this.title; }
    public int getLikes() { return this.likes; }
    public Genre getGenre() { return this.genre; }

    @Override
    public int compareTo(Movie o) {
        return 0;
    }
}