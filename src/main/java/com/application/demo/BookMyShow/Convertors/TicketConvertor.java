package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.RequestTicketdto;
import com.application.demo.BookMyShow.entity.Ticket;

public class TicketConvertor {

    public static Ticket convertTicketReqToTicket(RequestTicketdto RequestTicketdto){
        return Ticket.builder()
                .build();
    }

}
