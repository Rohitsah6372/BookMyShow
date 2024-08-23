package com.application.demo.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String movieName;
    Date showDateTIme;
    double totalAmount;
    String bookedSeats;
    String theatreName;
    String tickedId = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    ShowEntity showEntity;


}
