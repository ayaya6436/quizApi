package com.quizApi.quizApi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.quizApi.quizApi.models.Participation;
import com.quizApi.quizApi.service.ParticipationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("apiQuiz")
public class ParticipationController {
    private final ParticipationService participationService;

    @PostMapping("participations")
    public Participation create(@RequestBody Participation participation){
        return participationService.creer(participation);
    }


    
}
