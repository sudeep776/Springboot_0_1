package com.codingShuttle.Week1.IntroductiontoSpringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    Apple getBean(){
        return new Apple();
    }
}
