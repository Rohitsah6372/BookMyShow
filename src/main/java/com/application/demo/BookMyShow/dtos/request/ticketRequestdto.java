package com.application.demo.BookMyShow.dtos.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ticketRequestdto {

    int userId;
    int showId;

    List<String> requestSeats = new ArrayList<>();

    String theatreName;

}
