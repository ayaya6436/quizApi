package com.quizApi.quizApi.models;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Entity
@Table(name = "quiz")
@Getter
@Setter
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quiz")
    private Integer id;

    @Column(length = 50)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private User user;

    // Une quiz peut avoir plusieurs questions
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    ("quiz") // Ajout de cette annotation pour éviter la récursivité JSON avec Question
    private List<Question> questions;


     @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
     private List<Participation> participation;
}
