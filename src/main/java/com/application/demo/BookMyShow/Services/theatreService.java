package com.application.demo.BookMyShow.Services;


import com.application.demo.BookMyShow.Convertors.theatreConvertor;
import com.application.demo.BookMyShow.DAOs.TheatreRepo;
import com.application.demo.BookMyShow.dtos.request.RequestTheaterdto;
import com.application.demo.BookMyShow.entity.Theatre;
import com.application.demo.BookMyShow.entity.TheatreSeat;
import com.application.demo.BookMyShow.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class theatreService {
    @Autowired
    TheatreRepo theatreRepo;

    public String addTheater(RequestTheaterdto requestTheaterdto) throws  Exception{
        if(requestTheaterdto.getName() == null || requestTheaterdto.getLocation()==null){
            throw new Exception("Name ans location not found");
        }
        Theatre theatre = theatreConvertor.convertTheatreReqdtoToTheatre(requestTheaterdto);
        List<TheatreSeat> theatreSeatList = createTheatreSeats(requestTheaterdto, theatre);
        theatre.setTheatreSeats(theatreSeatList);
        theatreRepo.save(theatre);
        return "Theater Added Successfully";
    }
    private List<TheatreSeat> createTheatreSeats(RequestTheaterdto requestTheaterdto, Theatre theatre){
        int classicSeats = requestTheaterdto.getClassicSeatsCount();
        int premiunSeats = requestTheaterdto.getPremiumSeatsCount();
        List<TheatreSeat> theatreSeatList = new ArrayList<>();
        //creating classic seats
        for(int count =1; count <= classicSeats;count++){
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatType(SeatType.CLASSIC)
                    .theatre(theatre) // Set the theatre
                    .seatNo("C" + count)
                    .build();
            theatreSeatList.add(theatreSeat);
        }
        for(int count =1; count <= premiunSeats;count++){
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatType(SeatType.PREMIUM)
                    .seatNo("P" + count)
                    .theatre(theatre) // Set the theatre
                    .build();
            theatreSeatList.add(theatreSeat);
        }
        return theatreSeatList;
    }
}
