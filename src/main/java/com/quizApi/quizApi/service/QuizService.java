package com.quizApi.quizApi.service;

import java.util.List;

import com.quizApi.quizApi.models.Quiz;

public interface QuizService {
    //Creation quiz
    Quiz creer (Quiz quiz);
    //Avoir la liste des quizzes
    List<Quiz>lire();
     //avoir une quiz par id
    Quiz lire(Integer id_quiz);
    //Modifier une quiz
    Quiz modifier(Integer id_quiz, Quiz quiz);
    //Supprimer une quiz
    String supprimer(Integer id_quiz);
    //Avoir la liste des quizs associes a un user
    List<Quiz> AvoirListQuizParIdUser(Integer id_user);
   
}
