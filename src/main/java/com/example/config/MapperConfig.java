package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.persistence.mapper.QuestionMapper;


@Configuration
public class MapperConfig {
    @Bean
    QuestionMapper questionMapper(){
        return new QuestionMapper();
    }
}
