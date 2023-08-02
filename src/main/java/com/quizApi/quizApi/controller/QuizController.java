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

import com.quizApi.quizApi.service.QuizService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@AllArgsConstructor

@RequestMapping("/apiQuiz")
public class QuizController {
    //Injection de QuizService
    private final QuizService quizService;
    // private final UserService userService;

  @Operation(summary = "Crée un nouveau quiz")
    @ApiResponse(responseCode = "200", description = "Le quiz créé avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Quiz.class)) })
    @PostMapping("/quizs")
    public Quiz create(@RequestBody Quiz quiz){
       
        return quizService.creer(quiz);
    }

    @Operation(summary = "Récupère la liste de tous les quizzes enregistrés")
    @ApiResponse(responseCode = "200", description = "La liste des quizzes enregistrés",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Quiz.class)) })
    @GetMapping("/quizs")
    public List<Quiz> read(){
        return quizService.lire();
    }

    @Operation(summary = "Récupère les détails d'un quiz spécifié par son ID")
    @ApiResponse(responseCode = "200", description = "Le quiz avec l'ID spécifié s'il existe, sinon null",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Quiz.class)) })
                    
    @GetMapping("/quizs/{id_quiz}")
    public Quiz read(@PathVariable Integer id_quiz){
        return quizService.lire(id_quiz);
    }

    @Operation(summary = "Met à jour les informations d'un quiz spécifié par son ID")
    @ApiResponse(responseCode = "200", description = "Le quiz mis à jour avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Quiz.class)) })

    @PutMapping("quizs/{id_quiz}")
    public Quiz update(@PathVariable Integer id_quiz, @RequestBody Quiz quiz) {
         return quizService.modifier(id_quiz, quiz);
    }

    @Operation(summary = "Supprime un quiz spécifié par son ID")
    @ApiResponse(responseCode = "200", description = "Le quiz supprimé avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class)) })

    @DeleteMapping("quizs/{id_quiz}")
    public String delete(@PathVariable Integer id_quiz){
        return quizService.supprimer(id_quiz);
    }

    @Operation(summary = "Récupère la liste de tous les quizzes créés par un utilisateur spécifié par son ID")
    @ApiResponse(responseCode = "200", description = "La liste des quizzes créés par l'utilisateur avec l'ID spécifié",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Quiz.class)) })

    @GetMapping("quizs/users/{id_user}")
    public List<Quiz> AvoirListQuizParIdUser(@PathVariable Integer id_user) {
        return quizService.AvoirListQuizParIdUser(id_user);
    }

    @Operation(summary = "Crée un nouveau quiz pour un utilisateur spécifié par son ID")
    @ApiResponse(responseCode = "200", description = "Le quiz créé pour l'utilisateur avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Quiz.class)) })

    @PostMapping("/users/{id_user}/quizs")
    public Quiz creerQuizPourUser(@PathVariable Integer id_user, @RequestBody Quiz quiz) {
        return quizService.creerQuizPourUser(id_user, quiz);
    }


}