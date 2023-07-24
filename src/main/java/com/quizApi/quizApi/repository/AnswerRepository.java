package com.quizApi.quizApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizApi.quizApi.models.Answer;

public interface AnswerRepository extends JpaRepository<Answer ,Integer>{
    
}
