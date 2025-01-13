package com.codingShuttle.Week1.IntroductiontoSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    @Autowired
    private DB db;

    public String getData(){
        return db.getData();
    }
}
