package com.quizApi.quizApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizApi.quizApi.models.Participation;

public interface ParticipationRepository extends JpaRepository <Participation,Integer>{
    
    
}
