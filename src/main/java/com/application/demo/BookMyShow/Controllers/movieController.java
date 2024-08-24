package com.application.demo.BookMyShow.Controllers;
import com.application.demo.BookMyShow.Services.movieService;
import com.application.demo.BookMyShow.dtos.request.RequestMoviedto;
import com.application.demo.BookMyShow.entity.Movie;
import com.application.demo.BookMyShow.enums.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/movie")
public class movieController {
    @Autowired
    movieService movieService;
    @PostMapping("/add")
    public ResponseEntity<?> addmovie(@RequestBody RequestMoviedto requestMoviedto){
        try{
            String response = movieService.addMovie(requestMoviedto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            String msg = "Error in adding the movie:" + e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get/{name}")
    public Movie findMovie(@PathVariable String name){
        return movieService.findByMovieName(name);
    }
    @GetMapping("/findByLanguage/{language}")
    public List<Movie> getMovieByLanguage(@PathVariable Language language){
        return movieService.getMovieByLanguage(language);
    }
}
