package com.airwallex.test.calculator.operators;

import com.airwallex.calculator.CalculatorStack;
import com.airwallex.calculator.StackElement;
import com.airwallex.calculator.operators.DivisionOperator;
import com.airwallex.calculator.operators.SqrtOperator;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertFalse;

public class SqrtOperatorTest {


    @Test
    public void operationHasOneParameter() {
        SqrtOperator operator = new SqrtOperator();
        CalculatorStack stack = new CalculatorStack();
        stack.push(new StackElement(16));
        if (operator.execute(stack)) {
            assertEquals(1, stack.size());
            StackElement e = stack.pop();
            assertEquals(4.0, e.getValue());
            StackElement[] arr = e.getParams();
            assertEquals(1, arr.length);
            assertEquals(16.0, arr[0].getValue());
        } else {
            fail("Sqrt can be done with one parameter.");
        }
    }

    @Test
    public void operationOnEmptyStack() {
        SqrtOperator operator = new SqrtOperator();
        CalculatorStack stack = new CalculatorStack();
        assertFalse("Sqrt can not be done without any parameter.", operator.execute(stack));
    }

    @Test
    public void throwExceptionOnNegativeNumber() {
        SqrtOperator operator = new SqrtOperator();
        CalculatorStack stack = new CalculatorStack();
        stack.push(new StackElement(-1));
        try {
            if (operator.execute(stack)) {
                fail("An ArithmeticException should be thrown");
            } else {
                fail("Sqrt can be done with one parameter.");
            }
        } catch (Exception e) {
            assertTrue("Catch a wrong exception type", e instanceof ArithmeticException);
        }
    }
}
