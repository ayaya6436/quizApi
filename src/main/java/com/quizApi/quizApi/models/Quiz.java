package com.quizApi.quizApi.models;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    // Autres propriétés du quiz

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)

    // pour eviter sérialisation des donnees json
     @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;
}
