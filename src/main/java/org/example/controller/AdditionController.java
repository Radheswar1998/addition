package org.example.controller;

import org.example.service.AdditionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    private final AdditionService additionService;

    public AdditionController(AdditionService additionService) {
        this.additionService = additionService;
    }

    @PostMapping("/add")
    public Result addNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = additionService.addNumbers(num1, num2);

        return new Result(result, num1, num2);
    }



    public static class Result {
        private int sum;
        private int num1;
        private int num2;

        // getters and setters

        public Result(int sum, int num1, int num2) {
            this.sum = sum;
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }
    }
}
