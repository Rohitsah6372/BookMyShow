package com.application.demo.BookMyShow.DAOs;

import com.application.demo.BookMyShow.entity.Ticket;
import com.application.demo.BookMyShow.enums.ShowType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    @Query("SELECT t FROM Ticket t WHERE t.totalAmount >= :totalAmount")
    List<Ticket> findByAmount(@Param("totalAmount") double totalAmount);


}
