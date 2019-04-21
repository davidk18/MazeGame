package com.group4.Interpreter;
import java.util.Stack;

public class Combiner {
// fu git
    public Combiner() {
        String input = "ammo ammo +";
        Stack<Expression> stack = new Stack<>();

        String[] tokenList = input.split(" ");
        for (String s : tokenList) {
            if (isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                System.out.println("popped from stack : " +
                        leftExpression.interpret() + rightExpression.interpret());
                Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
                System.out.println(operator);
                int result = operator.interpret();
                ItemExpression resultExpression = new ItemExpression(result);
                stack.push(resultExpression);
                resultExpression.interpret();
            } else {
                Expression i = new ItemExpression(s);
                stack.push(i);
                i.interpret();
            }
        }
        System.out.println(stack.pop().interpret());
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    /**
     * Get expression for string
     */
    public static Expression getOperatorInstance(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "-":
                return new MinusExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
            default:
                return new PlusExpression(left, right);
        }
    }
}

