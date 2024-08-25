package com.application.demo.BookMyShow.Controllers;


import com.application.demo.BookMyShow.Services.TicketService;
import com.application.demo.BookMyShow.dtos.request.RequestTicketdto;
import com.application.demo.BookMyShow.entity.Ticket;
import com.application.demo.BookMyShow.enums.ShowType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<?> bookTicket(@RequestBody RequestTicketdto requestTicketdto){
        try{
            String msg = ticketService.addTicket(requestTicketdto);
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }catch (Exception e){
            String msg = "Error booking Ticket :" + e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }

    }


    @GetMapping("/totAmount")
    public ResponseEntity<?> findTotAmount(@RequestParam double amount) {
        try {
            List<Ticket> ticketList = ticketService.findTotAmount(amount);
            return new ResponseEntity<>(ticketList, HttpStatus.OK);
        } catch(Exception e) {
            String msg = "Error finding tickets with amount greater than: " + amount + " -- " + e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }




}
