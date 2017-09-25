package com.example.demo.jpa.controller;

import com.example.demo.jpa.model.Users;
import com.example.demo.jpa.respostiory.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by jdzfjfhnui on 2017-9-24.
 * 这是一个使用H2作为数据库的例子
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserJpaRespository userJpaRespostiory;

    @GetMapping(value = "/all")
    public List<Users> findAll(){
        return userJpaRespostiory.findAll();
    }

    @GetMapping(value = "/{name}")
    public  Users findByName(@PathVariable final String name){
        return userJpaRespostiory.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users)
    {
        userJpaRespostiory.save(users);
        return userJpaRespostiory.findByName(users.getName());
    }
}
