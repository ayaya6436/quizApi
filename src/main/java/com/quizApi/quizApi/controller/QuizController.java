package com.quizApi.quizApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApi.quizApi.models.Quiz;
import com.quizApi.quizApi.models.User;
import com.quizApi.quizApi.repersitory.UserRepository;
import com.quizApi.quizApi.service.QuizService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@AllArgsConstructor

@RequestMapping("/apiQuiz")
public class QuizController {
    //Injection de QuizService
    private final QuizService quizService;
        private final UserRepository userRepository;


    @PostMapping("/quizs")
    public Quiz create(@RequestBody Quiz quiz){
        Integer userId = quiz.getUser().getId(); // Récupérez l'ID de l'utilisateur du quiz

    User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

    quiz.setUser(user); // Définissez l'utilisateur sur le quiz

    return quizService.creer(quiz);

    }

    @GetMapping("/quizs")
    public List<Quiz> read(){
        return quizService.lire();
    }

    @GetMapping("/quizs/{id_quiz}")
    public Quiz read(@PathVariable Integer id_quiz){
        return quizService.lire(id_quiz);
    }

    @PutMapping("quizs/{id_quiz}")
    public Quiz update(@PathVariable Integer id_quiz, @RequestBody Quiz quiz) {
         return quizService.modifier(id_quiz, quiz);
    }

    @DeleteMapping("quizs/{id_quiz}")
    public String delete(@PathVariable Integer id_quiz){
        return quizService.supprimer(id_quiz);
    }
    @GetMapping("quizs/users/{id_user}")
    public List<Quiz> AvoirListQuizParIdUser(@PathVariable Integer id_user) {
        return quizService.AvoirListQuizParIdUser(id_user);
        
    }
    




}
