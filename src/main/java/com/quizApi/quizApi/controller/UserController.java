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

import com.quizApi.quizApi.models.Quiz;
import com.quizApi.quizApi.models.User;
import com.quizApi.quizApi.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

@RequestMapping("/apiQuiz") 
public class UserController {
    //Injection de userService
    private final UserService userService;
 
    @Operation(summary = "Crée un nouvel utilisateur")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "L'utilisateur créé avec succès",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = User.class)) }),
        @ApiResponse(responseCode = "400", description = "Mauvaise requête", content = @Content),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur", content = @Content) })
    @PostMapping("/users")
    public User create(@RequestBody User user){
        return userService.creer(user);
    }

    @Operation(summary = "Récupère la liste de tous les utilisateurs enregistrés")
    @ApiResponse(responseCode = "200", description = "La liste des utilisateurs enregistrés",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class)) })
    @GetMapping("/users")
    public List<User> read(){
        return userService.lire();
    }

    @Operation(summary = "Récupère les détails d'un utilisateur spécifié par son ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "L'utilisateur avec l'ID spécifié",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = User.class)) }),
        @ApiResponse(responseCode = "404", description = "L'utilisateur avec l'ID spécifié n'a pas été trouvé", content = @Content) })
    @GetMapping("/users/{id_user}")
    public User read(@PathVariable Integer id_user){
        return userService.lire(id_user);
    } 

    @Operation(summary = "Met à jour les informations d'un utilisateur spécifié par son ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "L'utilisateur mis à jour avec succès",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = User.class)) }),
        @ApiResponse(responseCode = "400", description = "Mauvaise requête", content = @Content),
        @ApiResponse(responseCode = "404", description = "L'utilisateur avec l'ID spécifié n'a pas été trouvé", content = @Content),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur", content = @Content) })
    @PutMapping("/users/{id_user}")
    public User update(@PathVariable Integer id_user, @RequestBody User user){
        return userService.modifier(id_user, user);
    }

    @Operation(summary = "Supprime un utilisateur spécifié par son ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "L'utilisateur supprimé avec succès",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = String.class)) }),
        @ApiResponse(responseCode = "404", description = "L'utilisateur avec l'ID spécifié n'a pas été trouvé", content = @Content),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur", content = @Content) })
    @DeleteMapping("/users/{id_user}")
    public String delete(@PathVariable Integer id_user){
        return userService.supprimer(id_user);
    }

    @Operation(summary = "Récupère la liste de tous les quiz créés par un utilisateur spécifié par son ID")
    @ApiResponse(responseCode = "200", description = "La liste des quiz créés par l'utilisateur avec l'ID spécifié",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Quiz.class)) })
    @GetMapping("/users/{id_user}/quizs")
    public List<Quiz> getUserQuizzes(@PathVariable Integer id_user) {
        return userService.avoirListQuizs(id_user);
    }
}


