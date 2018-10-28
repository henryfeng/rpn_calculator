package com.airwallex.test.calculator;

import com.airwallex.calculator.CalculatorStack;
import com.airwallex.calculator.StackElement;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StackTest {

    @Test
    public void stackBasicAction() {
        CalculatorStack stack = new CalculatorStack();
        StackElement e = new StackElement(10);
        stack.push(e);
        e = new StackElement(20);
        stack.push(e);
        e = new StackElement(30);
        stack.push(e);
        e = new StackElement(40);
        stack.push(e);
        assertEquals(4, stack.size());
        e = stack.pop();
        assertEquals(3, stack.size());
        assertEquals(40.0, e.getValue());
        e = stack.pop();
        assertEquals(2, stack.size());
        assertEquals(30.0, e.getValue());
        e = stack.pop();
        assertEquals(1, stack.size());
        assertEquals(20.0, e.getValue());
        e = stack.pop();
        assertEquals(0, stack.size());
        assertEquals(10.0, e.getValue());
    }

    @Test
    public void stackClearTest() {
        CalculatorStack stack = new CalculatorStack();
        StackElement e = new StackElement(10);
        stack.push(e);
        e = new StackElement(20);
        stack.push(e);
        e = new StackElement(30);
        stack.push(e);
        e = new StackElement(40);
        stack.push(e);
        assertEquals(4, stack.size());
        stack.clear();
        assertTrue("Stack should be empty after clear it.", stack.isEmpty());
    }
}
