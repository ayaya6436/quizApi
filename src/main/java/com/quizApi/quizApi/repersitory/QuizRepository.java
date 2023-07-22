package com.quizApi.quizApi.repersitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizApi.quizApi.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    
}
