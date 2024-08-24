package com.application.demo.BookMyShow.Controllers;
import com.application.demo.BookMyShow.Services.showService;
import com.application.demo.BookMyShow.dtos.request.RequestShowEntitydto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class showController {
    @Autowired
    showService showService;

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

}
