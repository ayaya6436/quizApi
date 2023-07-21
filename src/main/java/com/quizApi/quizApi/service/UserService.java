package com.quizApi.quizApi.service;

import java.util.List;

import com.quizApi.quizApi.models.User;

public interface UserService {
    //Creation user
    User creer(User user);

    //Avoir la liste des users
    List<User> lire();

    //Modifier les users
    User modifier(Integer id_user,User user);

    //Supprimer les users
    String supprimer(Integer id_user);
}