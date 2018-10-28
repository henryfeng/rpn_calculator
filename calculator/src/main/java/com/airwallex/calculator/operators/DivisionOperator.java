package com.airwallex.calculator.operators;

import com.airwallex.calculator.CalculatorStack;
import com.airwallex.calculator.StackElement;

/**
 * this operator implement an addition calculator.<br/>
 * it takes two numbers from the stack and does the division operation.<br/>
 * An ArithmeticException will be thrown when the divisor is zero.
 */

public class DivisionOperator extends AbstractOperator {

    @Override
    public StackElement calculate(CalculatorStack stack) {
        StackElement secondParam = stack.pop();
        if (secondParam.getValue() == 0) {
            throw new ArithmeticException();
        }
        StackElement firstParam = stack.pop();
        double value = firstParam.getValue() / secondParam.getValue();
        return new StackElement(value, firstParam, secondParam);
    }
}
