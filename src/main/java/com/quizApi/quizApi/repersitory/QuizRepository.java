package com.quizApi.quizApi.repersitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.quizApi.quizApi.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    List<Quiz> findByUser_Id(Integer id_user);
}
