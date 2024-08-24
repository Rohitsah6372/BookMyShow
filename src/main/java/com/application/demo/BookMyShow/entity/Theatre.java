package com.application.demo.BookMyShow.entity;

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
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    List<TheatreSeat> theatreSeats = new ArrayList<>();

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    List<ShowEntity> showEntities = new ArrayList<>();
}
