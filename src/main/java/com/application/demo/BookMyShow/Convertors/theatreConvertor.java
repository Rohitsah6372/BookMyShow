package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.RequestTheaterdto;
import com.application.demo.BookMyShow.entity.Theatre;

public class theatreConvertor {

    public  static Theatre convertTheatreReqdtoToTheatre(RequestTheaterdto RequestTheaterdto){
        return Theatre.builder()
                .name(RequestTheaterdto.getName())
                .location(RequestTheaterdto.getLocation())
                .build();
    }

}
