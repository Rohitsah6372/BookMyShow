package com.application.demo.BookMyShow.Services;
import com.application.demo.BookMyShow.Convertors.showEntityConvertor;
import com.application.demo.BookMyShow.DAOs.MovieRepo;
import com.application.demo.BookMyShow.DAOs.ShowRepo;
import com.application.demo.BookMyShow.DAOs.TheatreRepo;
import com.application.demo.BookMyShow.dtos.request.RequestShowEntitydto;
import com.application.demo.BookMyShow.entity.*;
import com.application.demo.BookMyShow.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class showService {

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    ShowRepo showRepo;

    public String addShow(RequestShowEntitydto requestShowEntitydto){
        ShowEntity showEntity = showEntityConvertor.convertShowEntityToShow(requestShowEntitydto);
        int movieId = requestShowEntitydto.getMovieId();
        int theatreId = requestShowEntitydto.getTheatreId();
        Movie movie = movieRepo.findById(movieId).get();
        Theatre theatre = theatreRepo.findById(theatreId).get();
        showEntity.setTheatre(theatre);
        List<ShowSeat> showSeatList = createShowSeat(requestShowEntitydto, showEntity);
        showEntity.setShowSeats(showSeatList);
        showEntity.setShowDateTimme(new Date());
        showEntity.setMovie(movie);
        showEntity.setUpdatedOn(requestShowEntitydto.getShowDateTime());
        showEntity = showRepo.save(showEntity);
         movie.getListShows().add(showEntity);
        theatre.getShowEntities().add(showEntity); // Add the show to the theatre's list of shows
        theatreRepo.save(theatre);
        return "show has been added Successfully";
    }


    private  List<ShowSeat> createShowSeat(RequestShowEntitydto requestShowEntitydto, ShowEntity showEntity){
        Theatre theatre = showEntity.getTheatre();
        List<TheatreSeat> theatreSeatList = theatre.getTheatreSeats();
        List<ShowSeat> showSeatList = new ArrayList<>();
        for(TheatreSeat theatreSeat :  theatreSeatList){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theatreSeat.getSeatNo());
            showSeat.setSeatType(theatreSeat.getSeatType());
            if(theatreSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(requestShowEntitydto.getClassicSeatPrice());
            }else{
                showSeat.setPrice(requestShowEntitydto.getPremiumSeatPrice());
            }
            showSeat.setBooked(false);
            showSeat.setShowEntity(showEntity);
            showSeatList.add(showSeat);
        }
        return showSeatList;
    }

    public String deleteAll() {
        showRepo.deleteAll();

        return "Deleted Successfully";
    }
}
