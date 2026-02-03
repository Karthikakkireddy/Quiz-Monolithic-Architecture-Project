package com.karthik.taskplatform.QuizMonolithicProject.repository;

import com.karthik.taskplatform.QuizMonolithicProject.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Integer>
{

}
