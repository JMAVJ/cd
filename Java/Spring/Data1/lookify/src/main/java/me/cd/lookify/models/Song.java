package me.cd.lookify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, max = 64, message = "El titulo debe estar entre 1 y 64")
    private String title;
    @Size(min = 1, max = 64, message = "El artista debe estar entre 1 y 64")
    private String artist;
    @Min(value = 1, message="The minimum rating is 1")
    @Max(value = 10, message = "The maximum rating is 10")
    private int rating;

    public Song() {

    }

    public Song(String title, String artist, int rating) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
