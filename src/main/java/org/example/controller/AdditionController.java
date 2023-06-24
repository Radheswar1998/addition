package org.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    @GetMapping("/add")
    public Result addNumbers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = num1 + num2;
        return new Result(result, num1, num2);
    }

    public static class Result {
        private int result;
        private int num1;
        private int num2;

        public Result(int result, int num1, int num2) {
            this.result = result;
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getResult() {
            return result;
        }

        public int getNum1() {
            return num1;
        }

        public int getNum2() {
            return num2;
        }
    }
}

