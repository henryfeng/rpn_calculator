package com.airwallex.test.calculator.operators;

import com.airwallex.calculator.CalculatorStack;
import com.airwallex.calculator.StackElement;
import com.airwallex.calculator.operators.AdditionOperator;
import com.airwallex.calculator.operators.DivisionOperator;
import com.airwallex.calculator.operators.MultiplicationOperator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;

public class DivisionOperatorTest {


    @Test
    public void operationHasTwoParameters() {
        DivisionOperator operator = new DivisionOperator();
        CalculatorStack stack = new CalculatorStack();
        stack.push(new StackElement(15));
        stack.push(new StackElement(3));
        if (operator.execute(stack)) {
            assertEquals(1, stack.size());
            StackElement e = stack.pop();
            assertEquals(5.0, e.getValue());
            StackElement[] arr = e.getParams();
            assertEquals(2, arr.length);
            assertEquals(15.0, arr[0].getValue());
            assertEquals(3.0, arr[1].getValue());
        } else {
            fail("Division can be done with two parameters.");
        }

    }

    @Test
    public void operationHasOneParameter() {
        DivisionOperator operator = new DivisionOperator();
        CalculatorStack stack = new CalculatorStack();
        stack.push(new StackElement(5));
        assertFalse("Division can not be done with one parameter", operator.execute(stack));
    }

    @Test
    public void throwExceptionOnDivideZero() {
        DivisionOperator operator = new DivisionOperator();
        CalculatorStack stack = new CalculatorStack();
        stack.push(new StackElement(15));
        stack.push(new StackElement(0));
        try {
            if (operator.execute(stack)) {
                fail("An ArithmeticException should be thrown");
            } else {
                fail("Division can not be done with one parameter.");
            }
        } catch (Exception e) {
            assertTrue("Catch a wrong exception type", e instanceof ArithmeticException);
        }
    }
}
