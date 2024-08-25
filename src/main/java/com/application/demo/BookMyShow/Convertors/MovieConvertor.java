package com.application.demo.BookMyShow.Convertors;
import com.application.demo.BookMyShow.dtos.request.RequestMoviedto;
import com.application.demo.BookMyShow.entity.Movie;
public class MovieConvertor {
    public  static Movie convertMovieReqToMovie(RequestMoviedto RequestMoviedto){
        return Movie.builder()
                .movieName(RequestMoviedto.getMoviename())
                .rating(RequestMoviedto.getRating())
                .language(RequestMoviedto.getLanguage())
                .genre(RequestMoviedto.getGenre())
                .duration(RequestMoviedto.getDuration())
                .build();
    }

}
