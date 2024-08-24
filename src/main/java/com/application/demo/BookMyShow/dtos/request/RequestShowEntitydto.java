package com.application.demo.BookMyShow.dtos.request;

import com.application.demo.BookMyShow.enums.ShowType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestShowEntitydto {


    Date showDateTime;
    ShowType showType;
    int movieId;
    int theatreId;
    double classicSeatPrice;
    double premiumSeatPrice;

}
