package com.application.demo.BookMyShow.Services;
import com.application.demo.BookMyShow.Convertors.MovieConvertor;
import com.application.demo.BookMyShow.DAOs.MovieRepo;
import com.application.demo.BookMyShow.dtos.request.RequestMoviedto;
import com.application.demo.BookMyShow.entity.Movie;
import com.application.demo.BookMyShow.enums.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;
    public String addMovie(RequestMoviedto requestMoviedto) {
        Movie movie = MovieConvertor.convertMovieReqToMovie(requestMoviedto);
        movieRepo.save(movie);
        return "movie added Successfully";
    }
    public Movie findByMovieName(String name){
        return  movieRepo.findByMovieName(name);
    }
    public List<Movie> getMovieByLanguage(Language language) {
          return movieRepo.findByLanguage(language);
    }
}
