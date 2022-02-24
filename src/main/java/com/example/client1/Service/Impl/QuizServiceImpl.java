package com.example.client1.Service.Impl;

import com.example.client1.DTO.NewsContent;
import com.example.client1.DTO.Quiz;
import com.example.client1.Service.QuizService;
import com.example.client1.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public int addCSV(Quiz newQuiz) {
        int i = jdbcTemplate.update("insert into news_quiz (id,question,optionA,optionB,optionC,optionD,optionE) values(?, ?, ?, ?, ?, ?, ?)",
                new Object[]{newQuiz.getId(), newQuiz.getOptionA(), newQuiz.getOptionB(), newQuiz.getOptionC(), newQuiz.getOptionD(), newQuiz.getOptionE()});

        return i;
    }


    @Override
    public List<Quiz> getQuiz() { return quizRepository.getQuiz(); }
}
