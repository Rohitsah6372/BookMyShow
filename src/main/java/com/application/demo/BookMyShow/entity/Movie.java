package com.application.demo.BookMyShow.entity;

import com.application.demo.BookMyShow.enums.Genre;
import com.application.demo.BookMyShow.enums.Language;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true, nullable = false)
    String movieName;
    int duration;
    double rating;

    @Enumerated(EnumType.STRING)
    Language language;

    @Enumerated(EnumType.STRING)
    Genre genre;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    List<ShowEntity> listShows = new ArrayList<>();



}
