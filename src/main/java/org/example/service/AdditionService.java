package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class AdditionService {

    public int addNumbers(int num1, int num2) {
        return num1 + num2;
    }
}
