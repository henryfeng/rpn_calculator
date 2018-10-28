package com.airwallex.calculator;

/**
 * To present an element for the calculator stack.<br/>
 * For a input value, there is only an number in the element.<br/>
 * For a calculated element, the original elements will be saved in the params field.
 */
public class StackElement {
    private double value;
    private StackElement[] params;

    public StackElement() {
    }

    public StackElement(double value) {
        this();
        this.value = value;
    }

    public StackElement(double value, StackElement param) {
        this(value);
        params = new StackElement[1];
        params[0] = param;
    }

    public StackElement(double value, StackElement firstParam, StackElement secondParam) {
        this(value);
        params = new StackElement[2];
        params[0] = firstParam;
        params[1] = secondParam;
    }

    public StackElement(double value, StackElement[] params) {
        this(value);
        this.params = params;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public StackElement[] getParams() {
        return params;
    }

    public void setParams(StackElement[] params) {
        this.params = params;
    }
}
