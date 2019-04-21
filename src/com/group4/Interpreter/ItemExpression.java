package com.group4.Interpreter;

import com.group4.Interfaces.Item;

public class ItemExpression extends Expression {
// fu git
    private int itemAttributeValue;

    public ItemExpression(String item) {
        this.itemAttributeValue = 15; //item.getDamage();
    }

    public ItemExpression(int itemValue){
        this.itemAttributeValue = itemValue;
    }

    @Override
    public int interpret() {
        return itemAttributeValue;
    }

    @Override
    public String toString() {
        return "number";
    }
}