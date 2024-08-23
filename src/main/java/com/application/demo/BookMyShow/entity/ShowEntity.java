package com.application.demo.BookMyShow.entity;
import com.application.demo.BookMyShow.enums.ShowType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date showDateTimme;
    Date updatedOn;
    @Enumerated(value = EnumType.STRING)
    ShowType showType;


    @ManyToOne
    @JoinColumn
    Movie movie;

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    List<ShowSeat> showSeats = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Theatre theatre;


}
