package com.karthik.taskplatform.QuizMonolithicProject.service;

import com.karthik.taskplatform.QuizMonolithicProject.domain.Questions;
import com.karthik.taskplatform.QuizMonolithicProject.domain.Quiz;
import com.karthik.taskplatform.QuizMonolithicProject.dto.QuestionResponseDTO;
import com.karthik.taskplatform.QuizMonolithicProject.repository.QuestionRepo;
import com.karthik.taskplatform.QuizMonolithicProject.repository.QuizRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.desktop.QuitEvent;
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

    public List<QuestionResponseDTO> getQuestions(int id)
    {
        Quiz quiz = quizRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID NOT FOUND " + id));
        List<Questions> questionsList = quiz.getQuestions();

        List<QuestionResponseDTO> questionResponseDTOS = questionsList.stream()
                .map(this::mapToQuestionResponse)
                .toList();

        return questionResponseDTOS;

    }

    private QuestionResponseDTO mapToQuestionResponse(Questions questions)
    {
        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setQuestionTitle(questions.getQuestionTitle());
        questionResponseDTO.setOption1(questions.getOption1());
        questionResponseDTO.setOption2(questions.getOption2());
        questionResponseDTO.setOption3(questions.getOption3());
        questionResponseDTO.setOption4(questions.getOption4());

        return questionResponseDTO;
    }
}
