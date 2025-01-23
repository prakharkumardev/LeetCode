package com.example.sprinttest.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope("request")
public class SomeService {

    private int x = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void printX(){
        System.out.println("value of x is : " + x);
    }
}