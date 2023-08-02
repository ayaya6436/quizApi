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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("apiQuiz")
public class AnswerController {
     private final AnswerService answerService;

     /**
     * Crée une nouvelle réponse.
     *
     * @param answer La réponse à créer (fournie dans le corps de la requête en tant que JSON).
     * @return La réponse créée avec ses détails.
     */
    @Operation(summary = "Crée une nouvelle réponse")
    @ApiResponse(responseCode = "200", description = "La réponse créée avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Answer.class)) })
    @PostMapping("/answers")
    public Answer create(@RequestBody Answer answer){
        return answerService.creer(answer);
    }

    /**
     * Récupère la liste de toutes les réponses enregistrées.
     *
     * @return La liste des réponses enregistrées.
     */
    @Operation(summary = "Récupère la liste de toutes les réponses enregistrées")
    @ApiResponse(responseCode = "200", description = "La liste des réponses enregistrées",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Answer.class)) })
    @GetMapping("/answers")
    public List<Answer> read() {
        return answerService.lire();
    }

    /**
     * Récupère les détails d'une réponse spécifiée par son ID.
     *
     * @param id_answer L'ID de la réponse dont on veut obtenir les détails.
     * @return La réponse avec l'ID spécifié si elle existe, sinon null.
     */
    @Operation(summary = "Récupère les détails d'une réponse spécifiée par son ID")
    @ApiResponse(responseCode = "200", description = "La réponse avec l'ID spécifié si elle existe, sinon null",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Answer.class)) })
    @GetMapping("/answer/{id_answer}")
    public Answer lire(@PathVariable Integer id_answer) {
        return answerService.lire(id_answer);
    }

    /**
     * Met à jour les informations d'une réponse spécifiée par son ID.
     *
     * @param id_answer L'ID de la réponse à mettre à jour.
     * @param answer    Les nouvelles informations de la réponse (fournies dans le corps de la requête en tant que JSON).
     * @return La réponse mise à jour avec ses nouvelles informations.
     */
    @Operation(summary = "Met à jour les informations d'une réponse spécifiée par son ID")
    @ApiResponse(responseCode = "200", description = "La réponse mise à jour avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Answer.class)) })
    @PutMapping("/answer/{id_answer}")
    public Answer update(@PathVariable Integer id_answer, @RequestBody Answer answer) {
        return answerService.modifier(id_answer, answer);
    }

    /**
     * Supprime une réponse spécifiée par son ID.
     *
     * @param id_answer L'ID de la réponse à supprimer.
     * @return Un message indiquant si la suppression a été effectuée avec succès ou non.
     */
    @Operation(summary = "Supprime une réponse spécifiée par son ID")
    @ApiResponse(responseCode = "200", description = "La réponse supprimée avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class)) })
    @DeleteMapping("/answer/{id_answer}")
    public String delete(@PathVariable Integer id_answer) {
        return answerService.supprimer(id_answer);
    }

    /**
     * Crée une nouvelle réponse pour une question spécifiée par son ID.
     *
     * @param id_question L'ID de la question pour laquelle on veut créer la réponse.
     * @param answer La réponse à créer (fournie dans le corps de la requête en tant que JSON).
     * @return La réponse créée pour la question avec ses détails.
     */
    @Operation(summary = "Crée une nouvelle réponse pour une question spécifiée par son ID")
    @ApiResponse(responseCode = "200", description = "La réponse créée pour la question avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Answer.class)) })
    @PostMapping("/questions/{id_question}/answers")
    public Answer creerAnswerPourQuestion(@PathVariable Integer id_question, @RequestBody Answer answer) {
        return answerService.creerAnswerPourQuestion(id_question, answer);
    }
    
}

