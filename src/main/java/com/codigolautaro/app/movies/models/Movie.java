package com.codigolautaro.app.movies.models;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(schema = "Movies")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NonNull
    private String title;
    @Column
    @NonNull
    private String genre;
    @Column
    @NonNull
    private int duration;
    @Column
    @NonNull
    private String description;

    public int getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
