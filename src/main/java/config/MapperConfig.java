package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import persistence.mapper.QuestionMapper;


@Configuration
public class MapperConfig {
    @Bean
    QuestionMapper questionMapper(){
        return new QuestionMapper();
    }
}
