package com.karthik.taskplatform.QuizMonolithicProject.repository;

import com.karthik.taskplatform.QuizMonolithicProject.domain.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Questions, Integer> {

    List<Questions> findByCategory(String category);
}
