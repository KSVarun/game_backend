package com.sundarland.game.bean;



import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Game title required")
    private String title;
    @NotBlank(message = "Platform on which the game runs required")
    private String platform;
    @NotNull(message = "Game score required")
    private Long score;
    @NotNull(message = "Game genre required")
    private String genre;
    @NotBlank(message = "Editors choice required")
    @Size(min = 1, max = 1, message = "Please update with Y or N")
    private String editors_choice;

    public Game() {
    }

    public Game(Long id, String title, String platform, Long score, String genre, String editors_choice) {
        this.id=id;
        this.title = title;
        this.platform = platform;
        this.score = score;
        this.genre = genre;
        this.editors_choice = editors_choice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEditors_choice() {
        return editors_choice;
    }

    public void setEditors_choice(String editors_choice) {
        this.editors_choice = editors_choice;
    }

    @Override
    public String toString() {
        return "Game{" +
                ", title='" + title + '\'' +
                ", platform='" + platform + '\'' +
                ", score=" + score +
                ", genre='" + genre + '\'' +
                ", editorsChoice='" + editors_choice + '\'' +
                '}';
    }
}
