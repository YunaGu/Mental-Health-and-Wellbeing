package com.example.client1.Service.Impl;

import com.example.client1.DTO.DepressionDTO;
import com.example.client1.DTO.Quiz;
import com.example.client1.Service.DepressionSevice;
import com.example.client1.Service.QuizService;
import com.example.client1.repository.DepressionRepository;
import com.example.client1.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepressionSeviceImpl implements DepressionSevice {
        @Autowired
        private DepressionRepository depressionRepository;

        @Override
        public List<DepressionDTO> getQues() { return depressionRepository.getQues(); }
}


