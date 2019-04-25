package com.group4.Interpreter;
import com.group4.Interfaces.Item;
import com.group4.Objects.InputReceiver;
import com.group4.Prototype.CharacterPrototype;
import junit.framework.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Stack;

public class WeaponCombiner {
    Item finishedItem;
    CharacterPrototype character;


    public WeaponCombiner(String testInput){

    }

    public WeaponCombiner(CharacterPrototype character) {
        this.character = character;
        combine();
    }

    public void combine(){
        ArrayList<Item> itemsCombined = new ArrayList<>();
        Stack<Expression> stack = new Stack<>();
        System.out.println("Enter the weapon numbers you wish to combine using postfix notation e.g. 2 3 + 5 +");
        String[] tokenList = InputReceiver.getInput().split(" ");
        finishedItem = character.getInventory().findItemByStringIndex(tokenList[0]);
        for (String s : tokenList) {
            if (isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
                int result = operator.interpret();
                ItemExpression resultExpression = new ItemExpression(result);
                stack.push(resultExpression);
                resultExpression.interpret();
            } else {
                Item itemToCombine = character.getInventory().findItemByStringIndex(s);
                if (itemToCombine != finishedItem){
                    itemsCombined.add(itemToCombine);
                }
                Expression i = new ItemExpression(itemToCombine);
                stack.push(i);
                i.interpret();
            }
        }
        int newDamage = stack.pop().interpret();
        finishedItem.setDamage(newDamage);
        for (Item item : itemsCombined){
            character.getInventory().removeItem(item);
        }
    }

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

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }



    protected int testPrefix(String testString){
        Stack<Expression> stack = new Stack<>();
        String[] tokenList = testString.split(" ");
        finishedItem = character.getInventory().findItemByStringIndex(tokenList[0]);
        for (String s : tokenList) {
            if (isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
                int result = operator.interpret();
                ItemExpression resultExpression = new ItemExpression(result);
                stack.push(resultExpression);
                resultExpression.interpret();
            } else {
                Expression i = new ItemExpression(Integer.parseInt(s));
                stack.push(i);
                i.interpret();
            }
        }
        return stack.pop().interpret();
    }

}

