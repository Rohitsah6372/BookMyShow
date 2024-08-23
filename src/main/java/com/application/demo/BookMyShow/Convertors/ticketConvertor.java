package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.ticketRequestdto;
import com.application.demo.BookMyShow.entity.Ticket;

public class ticketConvertor {

    public static Ticket convertTicketReqToTicket(ticketRequestdto ticketRequestdto){
        return Ticket.builder()
                .build();
    }

}
