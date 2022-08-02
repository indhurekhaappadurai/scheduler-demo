package com.scheduler.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scheduler.dto.UserDto;
import com.scheduler.entity.User_Details;
import com.scheduler.repo.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevice {
    @Autowired
    User_Repo repo;

    public String postData(UserDto userdto) {
        User_Details user = new User_Details();
        user.setFirstName(userdto.getFirstName());
        user.setFrequency(userdto.getFrequency());
        repo.save(user);
        return "Data Successfully added";
    }

    public User_Details getByFrequency(int i) throws JsonProcessingException {
        User_Details newUser = new User_Details();
        newUser = repo.getByFrequency(i);
        return newUser;
    }
}
