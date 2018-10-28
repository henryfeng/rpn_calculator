package com.airwallex.calculator;


import java.util.Stack;

/**
 * To implement a special stack for RPN calculator
 */
public class CalculatorStack {

    private static final String STACK_LABEL = "Stack:";
    private static final String SPACE = " ";
    private static final String REGEX_PADDING_ZERO = "\\.*0*$";
    private static final String NONE = "";


    private Stack<StackElement> stack;

    public CalculatorStack() {
        stack = new Stack<>();
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element the item to be pushed onto this stack.
     */
    public void push(StackElement element) {
        stack.push(element);
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    public StackElement pop() {
        return stack.pop();
    }

    /**
     * determine the stack is empty or not
     *
     * @return true for an empty stack
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * count the elements in the stack
     *
     * @return the number of elements in this stack
     */
    public int size() {
        return stack.size();
    }

    /**
     * clear the stack
     */
    public void clear() {
        stack.clear();
    }

    /**
     * Convert all numbers in the stack to an array
     *
     * @return an array with double type
     */
    public double[] toArray() {
        double[] result = new double[stack.size()];
        int i = 0;
        for (StackElement element : stack) {
            result[i] = element.getValue();
            i++;
        }
        return result;
    }

    /**
     * print all values in the stack
     */
    public void print() {
        System.out.print(STACK_LABEL);
        for (StackElement element : stack) {
            System.out.print(SPACE);
            System.out.print(formatValue(element.getValue()));
        }
        System.out.println();
    }

    /**
     * format a real number up to 10 precision
     *
     * @param value the real number
     * @return formatted the number string
     */
    private String formatValue(double value) {
        String text = String.format("%.10f", value);
        return text.replaceAll(REGEX_PADDING_ZERO, NONE);
    }
}
