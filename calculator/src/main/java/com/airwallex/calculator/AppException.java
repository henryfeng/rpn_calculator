package com.airwallex.calculator;

/**
 * This is an custom exception to present the wrong operator and position in the input text.
 */
public class AppException extends Exception {

    public AppException(String op, int pos) {
        super(String.format("operator %1$s (position: %2$d): insucient parameters", op, pos));
    }
}
