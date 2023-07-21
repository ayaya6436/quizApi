package com.quizApi.quizApi.models;



import java.util.List;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "quiz")
@Setter
@Getter
@NoArgsConstructor

public class Quiz {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id_quiz;

@Column(length=50)
private String nom;

@ManyToOne
@JoinColumn(name="id_user",nullable = false)
private User user;

@OneToMany(mappedBy="quiz",cascade = CascadeType.ALL)
private List<Question> question;




    
}
