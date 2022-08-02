package com.scheduler.controller;

import com.scheduler.dto.UserDto;
import com.scheduler.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserSevice userSevice;

    @PostMapping("/post")
    public String postData(@RequestBody UserDto userdto){
        return userSevice.postData(userdto);
    }
}
