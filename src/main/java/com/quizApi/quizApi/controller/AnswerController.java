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

import com.quizApi.quizApi.models.Answer;
import com.quizApi.quizApi.service.AnswerService;


import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("apiQuiz")
public class AnswerController {
     private final AnswerService answerService;

    @PostMapping("/answers")
    public Answer create(@RequestBody Answer answer){
        return answerService.creer(answer);
    }

    @GetMapping("/answers")
    public List<Answer> read() {
        return answerService.lire();
    }

    @GetMapping("/answer/{id_answer}")
    public Answer lire(@PathVariable Integer id_answer) {
        return answerService.lire(id_answer);
    }


    @PutMapping("/answer/{id_answer}")
    public Answer update(@PathVariable Integer id_answer, @RequestBody Answer answer) {
        return answerService.modifier(id_answer, answer);
    }

    @DeleteMapping("/answer/{id_answer}")
    public String delete(@PathVariable Integer id_answer) {
        return answerService.supprimer(id_answer);
    }
    


    @PostMapping("/questions/{id_question}/answers")
        public Answer creerAnswerPourQuestion(@PathVariable Integer id_question, @RequestBody Answer answer) {
        return answerService.creerAnswerPourQuestion(id_question, answer);
    }
    
}

