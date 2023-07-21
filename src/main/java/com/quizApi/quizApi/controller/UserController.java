package com.quizApi.quizApi.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApi.quizApi.models.User;
import com.quizApi.quizApi.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

@RequestMapping("/user") 
public class UserController {
    //Injection de userService
    private final UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.creer(user);
    }

    @GetMapping("read")
    public List<User> read(){
        return userService.lire();
    }

    @PutMapping("update/{id}")
    public User update(@PathVariable Integer id_user, @RequestBody User user){
        return userService.modifier( id_user,user);
    }

    @DeleteMapping("delete")
    public String delete(@PathVariable Integer id_user){
        return userService.supprimer(id_user);
    }

}
