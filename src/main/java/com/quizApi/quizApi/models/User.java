package com.quizApi.quizApi.models;

import java.util.List;



import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

 @Entity
 @Table(name = "user")
 @Setter
 @Getter
 @NoArgsConstructor
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    private Integer id_user;
    @Column(length=50)
    private String nom;

    @Column(length=50)
    private String prenom;

    @Column(length=50)
    private String username;

    @Column(length=150)
    private String password;

    @OneToMany(mappedBy="user",cascade= CascadeType.ALL)
    private List<Quiz> quiz;
   
}
