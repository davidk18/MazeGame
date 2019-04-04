package com.group4.Objects;

final class Direction {
    private Direction(String n){ _name = n; }
    public final static Direction North =
            new Direction("North");
    public final static Direction South =
            new Direction("South");
    public final static Direction East =
            new Direction("East");
    public final static Direction West =
            new Direction("West");
    public String toString(){ return _name; }
    private String _name;
}