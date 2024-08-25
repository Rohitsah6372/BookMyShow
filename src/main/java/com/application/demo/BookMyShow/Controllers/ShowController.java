package com.application.demo.BookMyShow.Controllers;
import com.application.demo.BookMyShow.Services.ShowService;
import com.application.demo.BookMyShow.dtos.request.RequestShowEntitydto;
import com.application.demo.BookMyShow.entity.ShowEntity;
import com.application.demo.BookMyShow.entity.Ticket;
import com.application.demo.BookMyShow.enums.ShowType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<?> addShow(@RequestBody RequestShowEntitydto requestShowEntitydto){
        try{
            String res = showService.addShow(requestShowEntitydto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }catch (Exception e){
            String msg = "Error adding in shows :" + e.getMessage() ;
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }
    }


    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll(){
        try{
            String msg = showService.deleteAll();
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch(Exception e){
            String msg = "Error in deleting :"+ e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/byShow")
    public ResponseEntity<?> findByShowType(@RequestParam ShowType showType){
        try{
            List<ShowEntity> showEntityList = showService.findByShowType(showType);
            return new ResponseEntity<>(showEntityList, HttpStatus.OK);
        }catch (Exception e){
            String msg = "Error finding by show Type : " + e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }

}
