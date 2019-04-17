package com.group4.Objects;

public class CharacterPrototype implements Cloneable {

    private String description;
    // private Inventory inventory;
    private boolean isEnemy;
    private boolean isAlive;
    private int health;
    private int damage;

    public CharacterPrototype(CharacterPrototype characterPrototype)
    {
        description = "default";
        //inventory = "null";
        isEnemy = false;
        isAlive = true;
        health = 100;
        damage = 10;
    }

    public CharacterPrototype(String description, /*Inventory inventory,*/boolean isEnemy, boolean isAlive, int health, int damage)
    {
        this.description = description;
        //this.inventory = inventory;
        this.isEnemy = isEnemy;
        this.isAlive = isAlive;
        this.health = health;
        this.damage = damage;
    }

    public CharacterPrototype(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public void setEnemy(boolean enemy) {
        isEnemy = enemy;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public CharacterPrototype clone() throws CloneNotSupportedException{
        return new CharacterPrototype(this);
    }
}
