package com.quizApi.quizApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizApi.quizApi.models.Question;

public interface QuestionRepository extends JpaRepository<Question ,Integer >{

    List<Question> findByQuiz_Id(Integer id_quiz);
    
}
