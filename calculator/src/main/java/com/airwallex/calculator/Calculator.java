package com.airwallex.calculator;

import com.airwallex.calculator.operators.*;

import java.util.HashMap;
import java.util.Map;

/**
 *  To implement an RPN calculator, process the input text and parse it and do the calculation.
 */
public class Calculator {

    private static final char WHITESPACE = ' ';
    private static final String OP_ADDITION = "+";
    private static final String OP_SUBTRACTION = "-";
    private static final String OP_MULTIPLICATION = "*";
    private static final String OP_DIVISION = "/";
    private static final String OP_SQRT = "sqrt";
    private static final String OP_UNDO = "undo";
    private static final String OP_CLEAR = "clear";
    private static final String REG_NUMBER = "^[+-]?(?:\\d+\\.?\\d*|\\d*\\.\\d+)$";

    private CalculatorStack stack;
    private Map<String, AbstractOperator> operatorMap;

    public Calculator() {
        stack = new CalculatorStack();
        initializeOperators();
    }

    /**
     * Parse the input text
     *
     * @param text the input text
     * @throws AppException anything wrong when parse and handle the text.
     */
    public void processText(String text) throws AppException {
        StringBuilder sbWord = new StringBuilder();
        boolean isWord = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!isWord) {
                if (c != WHITESPACE) {
                    isWord = true;
                    sbWord.append(c);
                }
            } else {
                if (c == WHITESPACE) {
                    isWord = false;
                    processWord(sbWord.toString(), i);
                    sbWord = new StringBuilder();
                } else {
                    sbWord.append(c);
                }
            }
        }
        if (isWord) {
            processWord(sbWord.toString(), text.length());
        }
    }

    /**
     * Process the parsed text.
     * if it is a number, push it into the stack, if it is an operator, perform the corresponding operation
     *
     * @param word the parsed text
     * @param pos  current text's position
     * @throws AppException anything wrong when do the processing
     */
    private void processWord(String word, int pos) throws AppException {
        if (isRealNumber(word)) {
            stack.push(new StackElement(Double.parseDouble(word)));
        } else if (operatorMap.containsKey(word)) {
            applyOperator(word, pos);
        } else {
            switch (word) {
                case OP_CLEAR:
                    stack.clear();
                    break;
                case OP_UNDO:
                    undo();
                    break;
                default:
                    //unknown operator
                    throw new AppException(word, pos);
            }
        }
    }

    /**
     * According to the operator to do the corresponding calculation
     *
     * @param operator the operator
     * @param pos      current operator's position in the text
     * @throws AppException anything wrong when do the calculation
     */
    private void applyOperator(String operator, int pos) throws AppException {
        AbstractOperator op = operatorMap.get(operator);
        if (op == null) {
            throw new AppException(operator, pos);
        }
        boolean result;
        try {
            result = op.execute(stack);
        } catch (ArithmeticException ae) {
            throw new AppException(operator, pos);
        }
        if (!result) {
            throw new AppException(operator, pos);
        }
    }


    /**
     * Restore the last operation.<br/>
     * if last operation is pushing a number, remove this number from stack; if last operation is an operator,
     * restore the values before operator.
     */
    private void undo() {
        if (!stack.isEmpty()) {
            StackElement s = stack.pop();
            if (s.getParams() != null) {
                for (StackElement e : s.getParams()) {
                    stack.push(e);
                }
            }
        }
    }

    /**
     * determine a piece of text is a number or not
     *
     * @param text the piece of text
     * @return true when the text is a number, false - when text is not a number
     */
    private boolean isRealNumber(String text) {
        return text != null && text.matches(REG_NUMBER);
    }

    /**
     * initialize operators' mapping, create calculator for each operator
     */
    private void initializeOperators() {
        operatorMap = new HashMap<>();
        operatorMap.put(OP_ADDITION, new AdditionOperator());
        operatorMap.put(OP_SUBTRACTION, new SubtractionOperator());
        operatorMap.put(OP_MULTIPLICATION, new MultiplicationOperator());
        operatorMap.put(OP_DIVISION, new DivisionOperator());
        operatorMap.put(OP_SQRT, new SqrtOperator());
    }

    /**
     * print all numbers in the stack
     */
    public void print() {
        stack.print();
    }

    public double[] getStackNumbers() {
        return stack.toArray();
    }
}
