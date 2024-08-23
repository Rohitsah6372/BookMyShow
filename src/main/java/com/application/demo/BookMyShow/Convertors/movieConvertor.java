package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.movieRequestdto;
import com.application.demo.BookMyShow.entity.Movie;

public class movieConvertor {

    public  static Movie convertMovieReqToMovie(movieRequestdto movieRequestdto){
        return Movie.builder()
                .movieName(movieRequestdto.getMoviename())
                .rating(movieRequestdto.getRating())
                .language(movieRequestdto.getLanguage())
                .genre(movieRequestdto.getGenre())
                .duration(movieRequestdto.getDuration())
                .build();
    }

}
