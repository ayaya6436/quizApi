package com.quizApi.quizApi.service;

import java.util.List;

import com.quizApi.quizApi.models.Question;


public interface QuestionService {
    //Creation question
    Question creer (Question question);
    //Avoir la liste des question
    List<Question>lire();
     //avoir une question par id
    Question lire(Integer id_question);
    //Modifier une question
    Question modifier(Integer id_question, Question question);
    //Supprimer une question
    String supprimer(Integer id_question);

    //creer une question pour quiz
    Question creerQuestionPourQuiz(Integer id_quiz, Question question);
    //Avoir la liste des question associes a un question
    List<Question> AvoirListQuestionParQuiz(Integer id_quiz);
}
