package com.example.client1.controller;

import com.example.client1.DTO.Quiz;
import com.example.client1.Service.QuizService;
import com.example.client1.Utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * rest controller
 */
@RestController
// Annotation for process request address mapping
@RequestMapping("/quizList")
public class QuizResourceController {

        @Resource
        private QuizService quizService;

        /**
         *
         * @param newQuiz
         * @return
         */
        //add resource
        @PostMapping("/addCSV")
        public Result<Integer> addCSV(@RequestBody Quiz newQuiz) {
            // eg: 1 indicates that the data has been added into database
            int i = quizService.addCSV(newQuiz);
            if (i == 1) {
                return new Result<Integer>("200", "successful", i);
            } else {
                return new Result<Integer>("400", "failed", i);
            }
        }


}
