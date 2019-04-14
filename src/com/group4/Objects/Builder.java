package com.group4.Objects;

public class Builder {

    private String description;
    private Inventory inventory;
    private boolean isEnemy;
    private boolean isAlive;
    private int health;
    private int damage;

    public Builder() { }

    public Builder(String description, Inventory inventory, boolean isEnemy, boolean isAlive, int health, int damage) {
        this.description = description;
        this.inventory = inventory;
        this.isEnemy = isEnemy;
        this.isAlive = isAlive;
        this.health = health;
        this.damage = damage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setEnemy(boolean enemy) {
        isEnemy = enemy;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public CharacterProduct build() {
        return new CharacterProduct(this);
    }
}
