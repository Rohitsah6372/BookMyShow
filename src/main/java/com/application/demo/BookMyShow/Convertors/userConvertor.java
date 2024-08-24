package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.RequestUserdto;
import com.application.demo.BookMyShow.entity.User;

public class userConvertor {

    public static User convertRequestToUser(RequestUserdto RequestUserdto){
        User user = User.builder()
                .name(RequestUserdto.getName())
                .age(RequestUserdto.getAge())
                .email(RequestUserdto.getEmail())
                .mobile(RequestUserdto.getMobile())
                .address(RequestUserdto.getAddress())
                .build();

        return  user;
    }

//    public  static  convertUserToUserResponse(User user){
//
//    }

}
