package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.showEntityRequestdto;
import com.application.demo.BookMyShow.entity.ShowEntity;

public class showEntityConvertor {

    public static ShowEntity convertShowEntityToShow(showEntityRequestdto showEntityRequestdto){
        return ShowEntity.builder()
                .showDateTimme(showEntityRequestdto.getShowDateTime())
                .showType(showEntityRequestdto.getShowType())
                .build();
    }

}
