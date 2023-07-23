package com.quizApi.quizApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quizApi.quizApi.models.Quiz;
import com.quizApi.quizApi.repersitory.QuizRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{
//Injection de QuizRepository
    private final QuizRepository quizRepository;


    @Override
    public Quiz creer(Quiz quiz) {
       
       return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> lire() {
        return quizRepository.findAll();
    }


     @Override
    public Quiz lire(Integer id_quiz,Quiz quiz) {
        Optional<Quiz> quizOptional = quizRepository.findById(id_quiz);
        return quizOptional.orElseThrow(()-> new RuntimeException("quiz non trouve"));
    }

    @Override
    public Quiz modifier(Integer id_quiz, Quiz quiz) {
        return quizRepository.findById(id_quiz)
            .map(q->{
                q.setNom(quiz.getNom());
                q.setQuestion(quiz.getQuestion());
                return quizRepository.save(q);

            }).orElseThrow(()-> new RuntimeException("quiz non trouve"));
        }

    @Override
    public String supprimer(Integer id_quiz) {
        quizRepository.deleteById(id_quiz);
        return "quiz supprimer avec success";
    }

   
  
    
}
