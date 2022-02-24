package com.example.client1;

import com.example.client1.DTO.Quiz;
import com.example.client1.Service.QuizService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class Test1 {
    @Resource
    private QuizService quizService;

    @Test
    void check(Quiz newQuiz){

        int i = quizService.addCSV(newQuiz);
        System.out.println(i);

    }

}
