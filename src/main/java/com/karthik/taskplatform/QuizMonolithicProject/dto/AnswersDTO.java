package com.karthik.taskplatform.QuizMonolithicProject.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AnswersDTO
{
    private Integer questionId;
    private String choosenAnswer;
}
