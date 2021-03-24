package com.example.quartz.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void baba(){
        for (int i = 0; i < 5; i++) {
            System.out.println("baba:"+i);
        }
    }
}
