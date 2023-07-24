package com.quizApi.quizApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quizApi.quizApi.models.Answer;
import com.quizApi.quizApi.models.Question;
import com.quizApi.quizApi.repository.AnswerRepository;
import com.quizApi.quizApi.repository.QuestionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Override
    public Answer creer(Answer answer) {
       return answerRepository.save(answer);
    }

    @Override
    public List<Answer> lire() {
        return answerRepository.findAll();
    }

    @Override
    public Answer lire(Integer id_answer) {
        Optional<Answer> answerOptional = answerRepository.findById(id_answer);
        return answerOptional.orElseThrow(() -> new RuntimeException("answer non trouvée"));
    }

    @Override
    public Answer modifier(Integer id_answer, Answer answer) {
        return answerRepository.findById(id_answer)
        .map(a->{
            a.setLibelle(answer.getLibelle());
            return answerRepository.save(a);
        }).orElseThrow(()-> new RuntimeException("Answer non answer"));
    }

    @Override
    public String supprimer(Integer id_answer) {
        answerRepository.findById(id_answer);
        return "Reponse supprimer avec succes";
    }

    @Override
    public Answer creerAnswerPourQuestion(Integer id_question, Answer answer) {
       Question question = questionRepository.findById(id_question)
        .orElseThrow(() -> new RuntimeException("User non trouvé"));
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }

    // @Override
    // public List<Answer> AvoirListReponseParQuestion(Integer id_question) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'AvoirListReponseParQuestion'");
    // }
    
}
