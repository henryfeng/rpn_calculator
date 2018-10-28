package com.airwallex.calculator.operators;

import com.airwallex.calculator.CalculatorStack;
import com.airwallex.calculator.StackElement;

/**
 * this operator implement an addition calculator.<br/>
 * it takes two numbers from the stack and does the addition operation.
 */
public class AdditionOperator extends AbstractOperator {

    @Override
    public StackElement calculate(CalculatorStack stack) {
        StackElement secondParam = stack.pop();
        StackElement firstParam = stack.pop();
        double value = firstParam.getValue() + secondParam.getValue();
        return new StackElement(value, firstParam, secondParam);
    }
}
