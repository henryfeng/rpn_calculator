package com.airwallex.calculator.operators;

import com.airwallex.calculator.CalculatorStack;
import com.airwallex.calculator.StackElement;
/**
 * this operator implement an addition calculator.<br/>
 * it takes one number from the stack and does the sqrt operation.<br/>
 * for a negative number, an ArithmeticException will be thrown.
 */

public class SqrtOperator extends AbstractOperator {

    @Override
    public  StackElement calculate(CalculatorStack stack) {
        StackElement param = stack.pop();
        if (param.getValue() < 0) {
            throw new ArithmeticException();
        }
        double value = Math.sqrt(param.getValue());
        return new StackElement(value, param);
    }

    @Override
    protected int countParameters() {
        return 1;
    }
}
