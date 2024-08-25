package com.application.demo.BookMyShow.Controllers;
import com.application.demo.BookMyShow.dtos.request.RequestTheaterdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.application.demo.BookMyShow.Services.TheatreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity<?> addTheatre(@RequestBody RequestTheaterdto requestTheaterdto){
        try{
            String res = theatreService.addTheater(requestTheaterdto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }catch (Exception e){
            String msg = "Error in adding Theatre :" + e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }

}
