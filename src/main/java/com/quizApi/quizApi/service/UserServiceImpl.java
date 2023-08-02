package com.quizApi.quizApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quizApi.quizApi.models.Quiz;
import com.quizApi.quizApi.models.User;
import com.quizApi.quizApi.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    // injection de UserRepository
    private final UserRepository userRepository;

    // creation
    @Override
    public User creer(User user) {
        return userRepository.save(user);
    }

    // avoir tout les users
    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }
    // avoir un user par id

    @Override
    public User lire(Integer id_user) {
        return userRepository.findById(id_user).orElse(null);
    }

    // avoir une quiz par id_user

    public List<Quiz> avoirListQuizs(Integer id_user) {
        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id_user));
        return user.getQuiz();
    }

    // modifier une quiz par id_user

    @Override
    public User modifier(Integer id_user, User user) {
        return userRepository.findById(id_user)
                .map(u -> {
                    u.setNom(user.getNom());
                    u.setPrenom(user.getPrenom());
                    u.setUsername(user.getUsername());
                    u.setPassword(user.getPassword());
                    return userRepository.save(u);
                }).orElseThrow(() -> new RuntimeException("User non trouve avec l'ID:" + id_user));
    }

    // supprimer une quiz par id_user

    @Override
    public String supprimer(Integer id_user) {
        userRepository.deleteById(id_user);
        return "user supprimer avec succes";
    }

}
