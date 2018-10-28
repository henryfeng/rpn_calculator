package com.airwallex.calculator.operators;

import com.airwallex.calculator.CalculatorStack;
import com.airwallex.calculator.StackElement;

/**
 * This abstract calculator can do the calculation for the corresponding operator
 */
public abstract class AbstractOperator {

    /**
     * to do the calculation
     *
     * @param stack current stack
     * @return ture - when finished the calculation, false - when there are not enough parameters in the stack
     */
    public boolean execute(CalculatorStack stack) {
        if (countParameters() > stack.size()) {
            return false;
        }
        stack.push(calculate(stack));
        return true;
    }

    /**
     * To implement it in the implementation class
     *
     * @param stack the number stack
     * @return the new element will be pushed into stack
     */
    protected abstract StackElement calculate(CalculatorStack stack);

    /**
     * how many parameters for this operator
     * @return the count of participating parameters
     */
    protected int countParameters() {
        return 2;
    }
}
