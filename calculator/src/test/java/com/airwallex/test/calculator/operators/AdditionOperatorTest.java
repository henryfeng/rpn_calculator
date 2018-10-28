package com.airwallex.test.calculator.operators;

import com.airwallex.calculator.CalculatorStack;
import com.airwallex.calculator.StackElement;
import com.airwallex.calculator.operators.AdditionOperator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;

public class AdditionOperatorTest {


    @Test
    public void operationHasTwoParameters() {
        AdditionOperator operator = new AdditionOperator();
        CalculatorStack stack = new CalculatorStack();
        stack.push(new StackElement(5));
        stack.push(new StackElement(3));
        if (operator.execute(stack)) {
            assertEquals(1, stack.size());
            StackElement e = stack.pop();
            assertEquals(8.0, e.getValue());
            StackElement[] arr = e.getParams();
            assertEquals(2, arr.length);
            assertEquals(5.0, arr[0].getValue());
            assertEquals(3.0, arr[1].getValue());
        } else {
            fail("Addition can be done with two parameters.");
        }

    }

    @Test
    public void operationHasOneParameter() {
        AdditionOperator operator = new AdditionOperator();
        CalculatorStack stack = new CalculatorStack();
        stack.push(new StackElement(5));
        assertFalse("Addition can not be done with one parameter.", operator.execute(stack));
    }
}
