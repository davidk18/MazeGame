package com.group4.Interceptor;

import com.group4.Objects.Room;

public class Context {

    private int health;
    private String description;
    private int damage;
    private boolean isAlive;

    Context(int health, String description, int damage, boolean isAlive){
        this.health = health;
        this.description = description;
        this.damage = damage;
        this.isAlive = isAlive;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
