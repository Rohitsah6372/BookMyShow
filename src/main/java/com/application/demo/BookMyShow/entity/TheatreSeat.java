package com.application.demo.BookMyShow.entity;


import com.application.demo.BookMyShow.enums.SeatType;
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
public class TheatreSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Enumerated(value = EnumType.STRING)
    SeatType seatType;

    @ManyToOne
    @JoinColumn
    Theatre theatre;

}
