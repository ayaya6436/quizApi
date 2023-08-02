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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
@AllArgsConstructor

@RestController
@RequestMapping("/apiQuiz")
public class QuestionContoller {
    private final QuestionService questionService;

    /**
     * Crée une nouvelle question.
     *
     * @param question La question à créer (fournie dans le corps de la requête en tant que JSON).
     * @return La question créée avec ses détails.
     */
    @Operation(summary = "Crée une nouvelle question")
    @ApiResponse(responseCode = "200", description = "La question créée avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Question.class)) })
    @PostMapping("/questions")
    public Question create(@RequestBody Question question){
        return questionService.creer(question);
    }

    /**
     * Récupère la liste de toutes les questions enregistrées.
     *
     * @return La liste des questions enregistrées.
     */
    @Operation(summary = "Récupère la liste de toutes les questions enregistrées")
    @ApiResponse(responseCode = "200", description = "La liste des questions enregistrées",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Question.class)) })
    @GetMapping("/questions")
    public List<Question> read() {
        return questionService.lire();
    }

    /**
     * Récupère les détails d'une question spécifiée par son ID.
     *
     * @param id_question L'ID de la question dont on veut obtenir les détails.
     * @return La question avec l'ID spécifié si elle existe, sinon null.
     */
    @Operation(summary = "Récupère les détails d'une question spécifiée par son ID")
    @ApiResponse(responseCode = "200", description = "La question avec l'ID spécifié si elle existe, sinon null",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Question.class)) })
    @GetMapping("/questions/{id_question}")
    public Question lire(@PathVariable Integer id_question) {
        return questionService.lire(id_question);
    }

    /**
     * Met à jour les informations d'une question spécifiée par son ID.
     *
     * @param id_question L'ID de la question à mettre à jour.
     * @param question    Les nouvelles informations de la question (fournies dans le corps de la requête en tant que JSON).
     * @return La question mise à jour avec ses nouvelles informations.
     */
    @Operation(summary = "Met à jour les informations d'une question spécifiée par son ID")
    @ApiResponse(responseCode = "200", description = "La question mise à jour avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Question.class)) })
    @PutMapping("/questions/{id_question}")
    public Question update(@PathVariable Integer id_question, @RequestBody Question question) {
        return questionService.modifier(id_question, question);
    }

    /**
     * Supprime une question spécifiée par son ID.
     *
     * @param id_question L'ID de la question à supprimer.
     * @return Un message indiquant si la suppression a été effectuée avec succès ou non.
     */
    @Operation(summary = "Supprime une question spécifiée par son ID")
    @ApiResponse(responseCode = "200", description = "La question supprimée avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class)) })
    @DeleteMapping("/questions/{id_question}")
    public String delete(@PathVariable Integer id_question) {
        return questionService.supprimer(id_question);
    }

    /**
     * Crée une nouvelle question pour un quiz spécifié par son ID.
     *
     * @param id_quiz L'ID du quiz pour lequel on veut créer la question.
     * @param question La question à créer (fournie dans le corps de la requête en tant que JSON).
     * @return La question créée pour le quiz avec ses détails.
     */
    @Operation(summary = "Crée une nouvelle question pour un quiz spécifié par son ID")
    @ApiResponse(responseCode = "200", description = "La question créée pour le quiz avec succès",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Question.class)) })
    @PostMapping("/quizs/{id_quiz}/questions")
    public Question creerQuestionPourQuiz(@PathVariable Integer id_quiz, @RequestBody Question question) {
        return questionService.creerQuestionPourQuiz(id_quiz, question);
    }

    /**
     * Récupère la liste de toutes les questions associées à un quiz spécifié par son ID.
     *
     * @param id_quiz L'ID du quiz pour lequel on veut récupérer la liste de questions.
     * @return La liste des questions associées au quiz avec l'ID spécifié.
     */
    @Operation(summary = "Récupère la liste de toutes les questions associées à un quiz spécifié par son ID")
    @ApiResponse(responseCode = "200", description = "La liste des questions associées au quiz avec l'ID spécifié",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Question.class)) })
    @GetMapping("/quizs/{id_quiz}/questions")
    public List<Question> obtenirListeQuestionsPourQuiz(@PathVariable Integer id_quiz) {
        return questionService.AvoirListQuestionParQuiz(id_quiz);
    }
    
}
