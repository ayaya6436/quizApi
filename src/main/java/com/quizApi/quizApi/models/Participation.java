package com.quizApi.quizApi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "participation")
@AllArgsConstructor
@Getter
@Setter
public class Participation {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_participer;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "id_user",nullable =false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_quiz",nullable =false)
    private Quiz quiz;


    
}
