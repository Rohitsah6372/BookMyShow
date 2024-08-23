package com.application.demo.BookMyShow.Convertors;

import com.application.demo.BookMyShow.dtos.request.userRequestdto;
import com.application.demo.BookMyShow.entity.User;

public class userConvertor {

    public static User convertRequestToUser(userRequestdto userRequestdto){
        User user = User.builder()
                .name(userRequestdto.getName())
                .age(userRequestdto.getAge())
                .email(userRequestdto.getEmail())
                .mobile(userRequestdto.getMobile())
                .address(userRequestdto.getAddress())
                .build();

        return  user;
    }

//    public  static  convertUserToUserResponse(User user){
//
//    }

}
