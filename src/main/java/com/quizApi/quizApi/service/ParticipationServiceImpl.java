package com.quizApi.quizApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quizApi.quizApi.models.Participation;
import com.quizApi.quizApi.repository.ParticipationRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ParticipationServiceImpl implements ParticipationService{
    private final ParticipationRepository participationRepository ;

    @Override
    public Participation creer(Participation participation) {
        return participationRepository.save(participation);
    }

    @Override
    public List<Participation> lire() {
       return participationRepository.findAll();
    }

    @Override
    public Participation lire(Integer id_participation) {
       return participationRepository.findById(id_participation)
       .orElseThrow(()->new RuntimeException("Participation not found"));
    }

    @Override
    public Participation modifier(Integer id_participation, Participation participation) {
       return participationRepository.findById(id_participation)
       .map(p->{
              p.setScore(participation.getScore());
              return participationRepository.save(p);  
       }).orElseThrow(()->new RuntimeException("Participation not found"));
    }

    @Override
    public String supprimer(Integer id_participation) {
        participationRepository.deleteById(id_participation);
        return "participation supprimer avec success";

    }
    
}
