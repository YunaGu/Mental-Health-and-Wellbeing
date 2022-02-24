package com.example.client1.Service;

import com.example.client1.DTO.NewsContent;
import com.example.client1.DTO.Quiz;

import java.util.List;

public interface QuizService {
    int addCSV(Quiz newQuiz);

    public abstract List<Quiz> getQuiz();
}
