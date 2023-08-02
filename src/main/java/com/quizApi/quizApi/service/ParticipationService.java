package com.quizApi.quizApi.service;

import java.util.List;

import com.quizApi.quizApi.models.Participation;
// import com.quizApi.quizApi.models.Question;

public interface ParticipationService {
      //Creation partcipation
    Participation creer (Participation participation);
    //Avoir la liste des des participants
    List<Participation>lire();
     //avoir une participation par id
    Participation lire(Integer id_participation);
    //Modifier une participation
    Participation modifier(Integer id_participation, Participation participation);
    //Supprimer une particiaption
    String supprimer(Integer id_participation);
}
