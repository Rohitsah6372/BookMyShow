package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.RequestShowEntitydto;
import com.application.demo.BookMyShow.entity.ShowEntity;

public class ShowEntityConvertor {

    public static ShowEntity convertShowEntityToShow(RequestShowEntitydto RequestShowEntitydto){
        return ShowEntity.builder()
                .showDateTimme(RequestShowEntitydto.getShowDateTime())
                .showType(RequestShowEntitydto.getShowType())
                .build();
    }

}
