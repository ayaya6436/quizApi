package com.quizApi.quizApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.quizApi.quizApi.models.Question;
import com.quizApi.quizApi.models.Quiz;
import com.quizApi.quizApi.repository.QuestionRepository;
import com.quizApi.quizApi.repository.QuizRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    //Injection de QuizRepository et de QuestionRepository
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    
    @Override
    public Question creer(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> lire() {
        return questionRepository.findAll();
    }

    @Override
    public Question lire(Integer id_question) {
        Optional<Question> questionOptional = questionRepository.findById(id_question);
        return questionOptional.orElseThrow(() -> new RuntimeException("Question non trouvée"));
    }

    @Override
    public Question modifier(Integer id_question, Question question) {
        return questionRepository.findById(id_question)
            .map(qest->{
                qest.setLibelle(question.getLibelle());
                return questionRepository.save(qest);

            }).orElseThrow(()-> new RuntimeException("Question non trouve"));
    }

    @Override
    public String supprimer(Integer id_question) {
        questionRepository.deleteById(id_question);
        return "Question supprimée avec succès";
    }


    @Override
    public Question creerQuestionPourQuiz(Integer id_quiz, Question question) {
      Quiz quiz = quizRepository.findById(id_quiz)
                .orElseThrow(() -> new RuntimeException("Quiz non trouvé"));
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }

    @Override
    public List<Question> AvoirListQuestionParQuiz(Integer id_quiz) {
        return questionRepository.findByQuiz_Id(id_quiz);
    }

    
    
}
