package com.codingShuttle.Week1.IntroductiontoSpringboot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//alternate this to appconfig
//@Component
public class Apple {
    void eatApple(){
        System.out.println("Eating apple")  ;
    }

    @PostConstruct
    void callThisBeforeAppleUSed(){
        System.out.println("Created before apple is used");
    }

    @PreDestroy
    void callThisBeforeDestroy(){
        System.out.println("Destroyed apple bean");
    }
}
