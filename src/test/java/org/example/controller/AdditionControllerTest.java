package org.example.controller;
import org.example.service.AdditionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdditionControllerTest {

    @Test
    void testAddNumbers() {
        // Arrange
        int num1 = 5;
        int num2 = 3;
        int expectedSum = 8;

        AdditionController additionController = new AdditionController(new AdditionService());

        // Act
        AdditionController.Result result = additionController.addNumbers(num1, num2);

        // Assert
        Assertions.assertEquals(expectedSum, result.getSum());
        Assertions.assertEquals(num1, result.getNum1());
        Assertions.assertEquals(num2, result.getNum2());
    }

    @Test
    void testAddNumbersWithNegativeNumbers() {
        // Arrange
        int num1 = -5;
        int num2 = 3;
        int expectedSum = -2;

        AdditionController additionController = new AdditionController(new AdditionService());

        // Act
        AdditionController.Result result = additionController.addNumbers(num1, num2);

        // Assert
        Assertions.assertEquals(expectedSum, result.getSum());
        Assertions.assertEquals(num1, result.getNum1());
        Assertions.assertEquals(num2, result.getNum2());
    }

    @Test
    void testAddNumbersWithLargeNumbers() {
        // Arrange
        int num1 = 2;
        int num2 = 5;
        int expectedSum = -2;

        AdditionController additionController = new AdditionController(new AdditionService());

        // Act
        AdditionController.Result result = additionController.addNumbers(num1, num2);

        // Assert
        Assertions.assertNotEquals(expectedSum, result.getSum());
    }
}



