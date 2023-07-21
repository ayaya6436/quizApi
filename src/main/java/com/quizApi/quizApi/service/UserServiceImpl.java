package com.quizApi.quizApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quizApi.quizApi.models.User;
import com.quizApi.quizApi.repersitory.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User creer(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> lire() {
       return userRepository.findAll();
    }

    @Override
    public User modifier(Integer id_user, User user) {
        return userRepository.findById(id_user)
        .map(u->{
            u.setNom(user.getNom());
            u.setPrenom(user.getPrenom());
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            return userRepository.save(u);
         }).orElseThrow(()->new RuntimeException("User non trouve"));
    }

    @Override
    public String supprimer(Integer id_user) {
        userRepository.deleteById(id_user);
        return "user supprimer avec succes";
    }
    
}
