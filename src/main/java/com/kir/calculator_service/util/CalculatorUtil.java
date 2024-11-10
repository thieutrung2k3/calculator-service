package com.kir.calculator_service.util;

import java.util.Stack;

public class CalculatorUtil {
    public static double calculate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == ' ')
                continue;

            if (Character.isDigit(currentChar)) {
                StringBuilder number = new StringBuilder();

                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                i--;
                values.push(Double.parseDouble(number.toString()));
            }

            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                while (!operators.isEmpty() && hasPrecedence(currentChar, operators.peek()))
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));

                operators.push(currentChar);
            }
        }

        while (!operators.isEmpty())
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    private static boolean hasPrecedence(char operator1, char operator2) {
        if (operator2 == '+' || operator2 == '-')
            return !(operator1 == '*' || operator1 == '/');

        return false;
    }

    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Không thể chia cho 0");
                return a / b;
            default:
                throw new UnsupportedOperationException("Phép toán không hợp lệ: " + operator);
        }
    }
}
