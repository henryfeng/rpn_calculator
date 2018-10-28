package com.airwallex.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (!"".equals(input)) {
            try {
                calculator.processText(input);
            } catch (AppException e) {
                System.out.println(e.getMessage());
            } finally {
                calculator.print();
            }
            input = br.readLine();
        }
    }
}
