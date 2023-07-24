package com.quizApi.quizApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name ="answer")
@Setter
@Getter
@NoArgsConstructor

public class Answer {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

private Integer id_answer;

@Column(length=50)
private String libelle;

@ManyToOne
@JoinColumn(name="id_question",nullable = false)
 @JsonIgnore
private Question question;


}
