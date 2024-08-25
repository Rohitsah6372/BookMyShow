package com.application.demo.BookMyShow.Services;
import com.application.demo.BookMyShow.Convertors.TicketConvertor;
import com.application.demo.BookMyShow.DAOs.ShowRepo;
import com.application.demo.BookMyShow.DAOs.TicketRepo;
import com.application.demo.BookMyShow.DAOs.UserRepo;
import com.application.demo.BookMyShow.dtos.request.RequestTicketdto;
import com.application.demo.BookMyShow.entity.ShowEntity;
import com.application.demo.BookMyShow.entity.ShowSeat;
import com.application.demo.BookMyShow.entity.Ticket;
import com.application.demo.BookMyShow.entity.User;
import com.application.demo.BookMyShow.enums.ShowType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TicketService {
    @Autowired
    ShowRepo showRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    JavaMailSender javaMailSender;

    public String addTicket(RequestTicketdto requestTicketdto) throws Exception{
        //convert the dto to entity
        Ticket ticket = TicketConvertor.convertTicketReqToTicket(requestTicketdto);
        //check whether seats are avialable or not
         boolean isSeatAvialable =  checkSeatsAvialiabilty(requestTicketdto);
         if(isSeatAvialable == false){
                throw new Exception("Requested Seats are already Occupied");
         }
         //total amount
        ShowEntity showEntity = showRepo.findById(requestTicketdto.getShowId()).get();
         List<ShowSeat> showSeatList = showEntity.getShowSeats();
         List<String> requestedSeats = requestTicketdto.getRequestSeats();
         double totalAmount =0;
         for(ShowSeat showSeat : showSeatList){
             if(requestedSeats.contains(showSeat.getSeatNo())){
                 totalAmount = totalAmount + showSeat.getPrice();
                 showSeat.setBooked(true);
             }
         }
         ticket.setTotalAmount(totalAmount);
         ticket.setMovieName(showEntity.getMovie().getMovieName());
         ticket.setShowDateTIme(showEntity.getShowDateTimme());
         ticket.setTheatreName(showEntity.getTheatre().getName());
         String allotedSeats = getAllocatedSeatsFor(requestedSeats);
         ticket.setBookedSeats(allotedSeats);
         ticket.setShowEntity(showEntity);
        User user = userRepo.findById((requestTicketdto.getUserId())).get();
        ticket.setUser(user);
        ticket  = ticketRepo.save(ticket);
        List<Ticket> ticketList = showEntity.getTickets();
        ticketList.add(ticket);
        showEntity.setTickets(ticketList);
        showRepo.save(showEntity);
        List<Ticket> ticketList1 = user.getTicket();
        ticketList1.add(ticket);
        showEntity.setTickets(ticketList1);
        userRepo.save(user);
        sendEmail(ticket);
        return "Ticket Booked Successfully";
    }
    private String getAllocatedSeatsFor(List<String> requestedSeats){
        String result ="";
        for(String seat : requestedSeats){
            result += seat + ",";
        }
        return result;
    }
    private Boolean checkSeatsAvialiabilty(RequestTicketdto requestTicketdto){
        int showId = requestTicketdto.getShowId();
        List<String> requestedSeats = requestTicketdto.getRequestSeats();
        ShowEntity showEntity =  showRepo.findById(showId).get();
        List<ShowSeat> showEntityList = showEntity.getShowSeats();
        for(ShowSeat showSeat :  showEntityList){
            String seatNo = showSeat.getSeatNo();
            if(requestedSeats.contains(seatNo)){
                if(showSeat.isBooked()){
                    return false;
                }
            }
        }
        return true;
    }

    private void sendEmail(Ticket ticket){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("rohitsah402@gmail.com");
        simpleMailMessage.setTo(ticket.getUser().getEmail());
        simpleMailMessage.setSubject("Booking Confirmed !!");
        simpleMailMessage.setText("Enjoy Your Day!! for movie : "+ ticket.getMovieName()  +
                " showDate :" + ticket.getShowDateTIme() +
                "Amount : "+ ticket.getTotalAmount());
        javaMailSender.send(simpleMailMessage);
    }

    public List<Ticket> findTotAmount(double amount) {

        return ticketRepo.findByAmount(amount);

    }


}
