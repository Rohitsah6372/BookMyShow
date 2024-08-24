package com.application.demo.BookMyShow.DAOs;
import com.application.demo.BookMyShow.entity.Movie;
import com.application.demo.BookMyShow.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String name);
    List<Movie> findByLanguage(Language language);

}
