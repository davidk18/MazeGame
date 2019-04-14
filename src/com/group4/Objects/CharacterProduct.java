package com.group4.Objects;

public class CharacterProduct {

    private final String description;
    private final Inventory inventory;
    private final boolean isEnemy;
    private final boolean isAlive;
    private final int health;
    private final int damage;

    public CharacterProduct(Builder builder) {
        this.description = builder.description;
        this.inventory = builder.inventory;
        this.isEnemy = builder.isEnemy;
        this.isAlive = builder.isAlive;
        this.health = builder.health;
        this.damage = builder.damage;
    }

}
