package com.application.demo.BookMyShow.entity;


import com.application.demo.BookMyShow.enums.SeatType;
import com.application.demo.BookMyShow.enums.ShowType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    boolean booked;
    double price;
    @Enumerated(value = EnumType.STRING)
    SeatType seatType;
    String seatNo;
    Date date;


    @ManyToOne
    @JoinColumn
    ShowEntity showEntity;


}
