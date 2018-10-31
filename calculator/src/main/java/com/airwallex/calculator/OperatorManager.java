package com.airwallex.calculator;

import com.airwallex.calculator.operators.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorManager {

    private static final OperatorManager instance = new OperatorManager();

    private static final String OP_ADDITION = "+";
    private static final String OP_SUBTRACTION = "-";
    private static final String OP_MULTIPLICATION = "*";
    private static final String OP_DIVISION = "/";
    private static final String OP_SQRT = "sqrt";

    private Map<String, AbstractOperator> operatorMap;

    private OperatorManager() {
        operatorMap = new HashMap<>();
        operatorMap.put(OP_ADDITION, new AdditionOperator());
        operatorMap.put(OP_SUBTRACTION, new SubtractionOperator());
        operatorMap.put(OP_MULTIPLICATION, new MultiplicationOperator());
        operatorMap.put(OP_DIVISION, new DivisionOperator());
        operatorMap.put(OP_SQRT, new SqrtOperator());
    }

    public static final OperatorManager getInstance() {
        return instance;
    }

    /**
     * check the map contains the operator or not.
     *
     * @param key the operator's name
     * @return true if map contains.
     */
    public boolean contains(String key) {
        return operatorMap.containsKey(key);
    }

    /**
     * Get an operator by the key
     *
     * @param key the operator's text
     * @return an operator instance
     */
    public AbstractOperator get(String key) {
        return operatorMap.get(key);
    }
}
