package com.userinsecure.secret.controller;

import com.userinsecure.secret.db.UserRepository;
import com.userinsecure.secret.model.User;
import org.springframework.web.bind.annotation.*;
import com.userinsecure.secret.db.UserRepository;
import com.userinsecure.secret.model.User;

import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    private UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("users")
    public List<User> users(){
        return this.userRepository.findAll();
    }

    @RequestMapping(value = "/users/adduser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

}