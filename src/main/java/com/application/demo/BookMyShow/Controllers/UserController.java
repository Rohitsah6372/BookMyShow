package com.application.demo.BookMyShow.Controllers;


import com.application.demo.BookMyShow.Services.UserService;
import com.application.demo.BookMyShow.dtos.request.RequestUserdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser( @RequestBody RequestUserdto requestUserdto){
        try{
            String respnse =  userService.addUser(requestUserdto);
            return new ResponseEntity<>(respnse, HttpStatus.CREATED);
        }catch (Exception e){
            String msg = "User Could not be added :" + e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }


}
