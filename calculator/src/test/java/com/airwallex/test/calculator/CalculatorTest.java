package com.airwallex.test.calculator;

import com.airwallex.calculator.AppException;
import com.airwallex.calculator.Calculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class CalculatorTest {

    @Test
    public void pushNumbersTest() {
        Calculator calculator = new Calculator();
        try {
            calculator.processText("5 3");
            double[] values = calculator.getStackNumbers();
            assertEquals("It should two numbers in the stack", values.length, 2);
            assertEquals("The first number should be 5", values[0], 5.0);
            assertEquals("The second number should be 3", values[1], 3.0);
        } catch (AppException e) {
            fail("What happed! Shouldn't catch any exception here.");
        }
    }

    @Test
    public void undoNumbersTest() {
        Calculator calculator = new Calculator();
        try {
            calculator.processText("5 3 2 1 undo undo");
            double[] values = calculator.getStackNumbers();
            assertEquals("It should two numbers in the stack", values.length, 2);
            assertEquals("The first number should be 5", values[0], 5.0);
            assertEquals("The second number should be 3", values[1], 3.0);
        } catch (AppException e) {
            fail("What happed! Shouldn't catch any exception here.");
        }
    }

    @Test
    public void undoOperatorTest() {
        Calculator calculator = new Calculator();
        try {
            calculator.processText("5 3 + undo");
            double[] values = calculator.getStackNumbers();
            assertEquals("It should two numbers in the stack", values.length, 2);
            assertEquals("The first number should be 5", values[0], 5.0);
            assertEquals("The second number should be 3", values[1], 3.0);
        } catch (AppException e) {
            fail("What happed! Shouldn't catch any exception here.");
        }
    }

    @Test
    public void twoInputLinesTest() {
        Calculator calculator = new Calculator();
        try {
            calculator.processText("5 3 4 5");
            calculator.processText("undo +");
            double[] values = calculator.getStackNumbers();
            assertEquals("It should two numbers in the stack", values.length, 2);
            assertEquals("The first number should be 5", values[0], 5.0);
            assertEquals("The second number should be 7", values[1], 7.0);
        } catch (AppException e) {
            fail("What happed! Shouldn't catch any exception here.");
        }
    }

    @Test
    public void multipleInputLinesWithOperatorsTest() {
        Calculator calculator = new Calculator();
        try {
            calculator.processText("7 12 2 /");
            double[] values = calculator.getStackNumbers();
            assertEquals("It should two numbers in the stack", values.length, 2);
            assertEquals("The first number should be 7", values[0], 7.0);
            assertEquals("The second number should be 6", values[1], 6.0);
            calculator.processText("*");
            values = calculator.getStackNumbers();
            assertEquals("It should only one numbers in the stack", values.length, 1);
            assertEquals("The first number should be 42", values[0], 42.0);
            calculator.processText("4 /");
            values = calculator.getStackNumbers();
            assertEquals("It should only one numbers in the stack", values.length, 1);
            assertEquals("The first number should be 10.5", values[0], 10.50);
        } catch (AppException e) {
            fail("What happed! Shouldn't catch any exception here.");
        }
    }

    @Test
    public void shouldCatchInsucientParameters() {
        Calculator calculator = new Calculator();
        try {
            calculator.processText("1 2 3 * 5 + * * 6 5");
            fail("an exception should be catched");
        } catch (AppException e) {
            //Great, it catches the insucient parameter
        }
    }
}
