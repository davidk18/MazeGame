package com.group4.Interpreter;

import com.group4.Interfaces.Item;

public abstract class Expression {

    public abstract int interpret();

    @Override
    public abstract String toString();
}