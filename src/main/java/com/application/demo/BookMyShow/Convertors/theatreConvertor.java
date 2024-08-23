package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.theaterRequestdto;
import com.application.demo.BookMyShow.entity.Theatre;

public class theatreConvertor {

    public  static Theatre convertTheatreReqdtoToTheatre(theaterRequestdto theaterRequestdto){
        return Theatre.builder()
                .name(theaterRequestdto.getName())
                .location(theaterRequestdto.getLocation())
                .build();
    }

}
