package com.application.demo.BookMyShow.Services;


import com.application.demo.BookMyShow.Convertors.userConvertor;
import com.application.demo.BookMyShow.DAOs.UserRepo;
import com.application.demo.BookMyShow.dtos.request.RequestUserdto;
import com.application.demo.BookMyShow.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {


    @Autowired
    UserRepo userRepo;

    public String addUser(RequestUserdto requestUserdto) {

        User user = userConvertor.convertRequestToUser(requestUserdto);
        userRepo.save(user);
        return "User Added Successfully";

    }
}
