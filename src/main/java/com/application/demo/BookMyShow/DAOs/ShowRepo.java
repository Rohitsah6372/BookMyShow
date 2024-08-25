package com.application.demo.BookMyShow.DAOs;

import com.application.demo.BookMyShow.entity.ShowEntity;
import com.application.demo.BookMyShow.entity.Ticket;
import com.application.demo.BookMyShow.enums.ShowType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepo extends JpaRepository<ShowEntity, Integer> {

    @Query("SELECT s FROM ShowEntity s WHERE s.showType = :showType")
    List<ShowEntity> findByShowType(ShowType showType);

}
