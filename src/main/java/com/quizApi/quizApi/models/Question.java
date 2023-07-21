package com.quizApi.quizApi.models;



import java.util.List;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "question")
@Setter
@Getter
@NoArgsConstructor
public class Question {
    @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_question;

    @Column(length=50)
    private String libelle;

    @ManyToOne 
    @JoinColumn(name = "id_quiz", nullable = false)
    private Quiz quiz;

    @OneToMany(mappedBy ="question",cascade =CascadeType.ALL)
    private List<Answer> answer;

    
}
