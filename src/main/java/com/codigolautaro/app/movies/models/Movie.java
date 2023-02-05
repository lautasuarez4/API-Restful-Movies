package com.codigolautaro.app.movies.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema = "Movies")
@Data
@NoArgsConstructor
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private int duration;
    @Column
    private String description;

}
