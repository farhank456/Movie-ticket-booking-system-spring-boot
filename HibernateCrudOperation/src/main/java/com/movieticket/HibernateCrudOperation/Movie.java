package com.movieticket.HibernateCrudOperation;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private int duration;

    @Column(name = "language")
    private String language;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "status")
    private String status;


    // Default Constructor
    public Movie() {
    }


    // Parameterized Constructor
    public Movie(String title,
                 String description,
                 String genre,
                 int duration,
                 String language,
                 LocalDate releaseDate,
                 String status) {

        this.title = title;
        this.description = description;
        this.genre = genre;
        this.duration = duration;
        this.language = language;
        this.releaseDate = releaseDate;
        this.status = status;
    }


    // Getter and Setter for movieId
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    // Getter and Setter for duration
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    // Getter and Setter for language
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    // Getter and Setter for releaseDate
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // toString()
    @Override
    public String toString() {

        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                ", releaseDate=" + releaseDate +
                ", status='" + status + '\'' +
                '}';
    }
}