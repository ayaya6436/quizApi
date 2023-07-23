package com.quizApi.quizApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quizApi.quizApi.models.Quiz;
import com.quizApi.quizApi.models.User;
import com.quizApi.quizApi.repersitory.QuizRepository;
import com.quizApi.quizApi.repersitory.UserRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{
//Injection de QuizRepository
    private final QuizRepository quizRepository;


    private final UserRepository userRepository;

    @Override
    public Quiz creer(Quiz quiz) {
        // Vérifier si l'utilisateur existe dans la base de données
        User user = userRepository.findById(quiz.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // Associer l'utilisateur au quiz
        quiz.setUser(user);

        return quizRepository.save(quiz);
    }
    @Override
    public List<Quiz> lire() {
        return quizRepository.findAll();
    }


     @Override
    public Quiz lire(Integer id_quiz) {
        Optional<Quiz> quizOptional = quizRepository.findById(id_quiz);
        return quizOptional.orElseThrow(()-> new RuntimeException("quiz non trouve"));
    }

    @Override
    public Quiz modifier(Integer id_quiz, Quiz quiz) {
        return quizRepository.findById(id_quiz)
            .map(q->{
                q.setNom(quiz.getNom());
                return quizRepository.save(q);

            }).orElseThrow(()-> new RuntimeException("quiz non trouve"));
        }

    @Override
    public String supprimer(Integer id_quiz) {
        quizRepository.deleteById(id_quiz);
        return "quiz supprimer avec success";
    }

    @Override
    public List<Quiz> AvoirListQuizParIdUser(Integer id_user) {
        return quizRepository.findByUser_Id(id_user);
    }

   
  
    
}
