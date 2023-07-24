package com.quizApi.quizApi.service;

import java.util.List;

import com.quizApi.quizApi.models.Answer;


public interface AnswerService {
    //Creation reponse
    Answer creer (Answer answer);
    //Avoir la liste des reponses
    List<Answer>lire();
     //avoir une reponse par id
    Answer lire(Integer id_qanswer);
    //Modifier une reponse
    Answer modifier(Integer id_answer, Answer answer);
    //Supprimer une reponse
    String supprimer(Integer id_answer);

    //creer une reponse pour question
    Answer creerAnswerPourQuestion(Integer id_question, Answer answer);
    //Avoir la liste des reponses associes a un question
    // List<Answer> AvoirListReponseParQuestion(Integer id_question);
}
