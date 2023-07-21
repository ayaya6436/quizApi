package com.quizApi.quizApi.repersitory;

import com.quizApi.quizApi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Integer> {
    
}
