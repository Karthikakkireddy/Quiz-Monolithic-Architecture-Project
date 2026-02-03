package com.karthik.taskplatform.QuizMonolithicProject.service;

import com.karthik.taskplatform.QuizMonolithicProject.domain.Questions;
import com.karthik.taskplatform.QuizMonolithicProject.domain.Quiz;
import com.karthik.taskplatform.QuizMonolithicProject.repository.QuestionRepo;
import com.karthik.taskplatform.QuizMonolithicProject.repository.QuizRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService
{
    private final QuizRepo quizRepo;
    private final QuestionRepo questionRepo;

    public Quiz createQuiz(String category, int numQ, String title)
    {
        List<Questions> questionsList = questionRepo.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionsList);

        return  quizRepo.save(quiz);
    }
}
