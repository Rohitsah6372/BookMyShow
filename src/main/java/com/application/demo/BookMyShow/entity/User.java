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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    @Column(unique = true, nullable = false)
    String email;
    String mobile;
    String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Ticket> ticket = new ArrayList<>();


}
