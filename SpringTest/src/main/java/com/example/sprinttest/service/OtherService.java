package com.example.sprinttest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherService {
    @Autowired
   SomeService someService;
    @GetMapping
    public void test(){
        someService.printX();
        System.out.println("chane the value");
        someService.setX(10001);

    }
}
