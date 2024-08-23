package com.application.demo.BookMyShow.DAOs;

import com.application.demo.BookMyShow.entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends JpaRepository<ShowEntity, Integer> {
}
