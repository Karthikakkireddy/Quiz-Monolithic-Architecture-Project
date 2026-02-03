package com.karthik.taskplatform.QuizMonolithicProject.service;

import com.karthik.taskplatform.QuizMonolithicProject.domain.Questions;
import com.karthik.taskplatform.QuizMonolithicProject.repository.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class QuestionService
{
    private final QuestionRepo questionRepo;

    public List<Questions> getAllQuestions()
    {
        return questionRepo.findAll();
    }

    public List<Questions> getQuestionsByCategory(String category)
    {
        return questionRepo.findByCategory(category);
    }

    public Questions createQuestion(Questions question)
    {
        return questionRepo.save(question);
    }
}
