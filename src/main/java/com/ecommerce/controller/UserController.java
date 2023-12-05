package com.ecommerce.controller;

import com.ecommerce.dao.UserDao;
import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        return this.userService.RegisterNewUser(user);
    }

    @GetMapping("{/forAdmin}")
    public String forAdmin(){
        return "This URL Is only Accesible to admin";
    }
    @GetMapping("{/forUser}")
    public String forUser(){
        return "This URL Is only Accesible to User";
    }
}
