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

import com.quizApi.quizApi.models.Question;
import com.quizApi.quizApi.service.QuestionService;

import lombok.AllArgsConstructor;
@AllArgsConstructor

@RestController
@RequestMapping("/apiQuiz")
public class QuestionContoller {
    private final QuestionService questionService;

    @PostMapping("/questions")
    public Question create(@RequestBody Question question){
        return questionService.creer(question);
    }

    @GetMapping("/questions")
    public List<Question> read() {
        return questionService.lire();
    }

    @GetMapping("/questions/{id_question}")
    public Question lire(@PathVariable Integer id_question) {
        return questionService.lire(id_question);
    }


    @PutMapping("/questions/{id_question}")
    public Question update(@PathVariable Integer id_question, @RequestBody Question question) {
        return questionService.modifier(id_question, question);
    }

    @DeleteMapping("/questions/{id_question}")
    public String delete(@PathVariable Integer id_question) {
        return questionService.supprimer(id_question);
    }

    @PostMapping("/quizs/{id_quiz}/questions")
    public Question creerQuestionPourQuiz(@PathVariable Integer id_quiz, @RequestBody Question question) {
        return questionService.creerQuestionPourQuiz(id_quiz, question);
    }
    
    @GetMapping("/quizs/{id_quiz}/questions")
    public List<Question> obtenirListeQuestionsPourQuiz(@PathVariable Integer id_quiz) {
        return questionService.AvoirListQuestionParQuiz(id_quiz);
    }
    
}
