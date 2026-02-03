package com.karthik.taskplatform.QuizMonolithicProject.controller;


import com.karthik.taskplatform.QuizMonolithicProject.domain.Quiz;
import com.karthik.taskplatform.QuizMonolithicProject.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController
{

    private final QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                quizService.createQuiz(category, numQ, title)
        );
    }
}
