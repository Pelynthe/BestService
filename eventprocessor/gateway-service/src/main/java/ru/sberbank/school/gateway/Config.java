package ru.sberbank.school.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }
}
