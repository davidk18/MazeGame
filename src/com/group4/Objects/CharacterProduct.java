package com.group4.Objects;

public class CharacterProduct { //character being created with builder, but immutable objects for correct builder implementation so could not be used
    //used builder instead for creating traps
    //character created instead with prototype see characterPrototype.java

    private final String description;
    // private final Inventory inventory;
    private final boolean isEnemy;
    private final boolean isAlive;
    private int health; //builder usually has all variables immutable, but for how we use character we need to be able to update health.
    private final int damage;

    public CharacterProduct(Builder builder) {
        this.description = builder.description;
        // this.inventory = builder.inventory;
        this.isEnemy = builder.isEnemy;
        this.isAlive = builder.isAlive;
        this.health = builder.health;
        this.damage = builder.damage;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int newHealth) { this.health = newHealth;}
    //builder usually has no set methods but we need to be able to update the characters health after attacks.

    public static class Builder {

        private String description;
        // private Inventory inventory;
        private boolean isEnemy;
        private boolean isAlive;
        private int health;
        private int damage;

        public Builder() {
        }

        public Builder(String description, /*Inventory inventory,*/ boolean isEnemy, boolean isAlive, int health, int damage) {
            this.description = description;
            //this.inventory = inventory;
            this.isEnemy = isEnemy;
            this.isAlive = isAlive;
            this.health = health;
            this.damage = damage;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

    /*  public Builder setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }*/

        public Builder setEnemy(boolean enemy) {
            isEnemy = enemy;
            return this;
        }

        public Builder setAlive(boolean alive) {
            isAlive = alive;
            return this;
        }

        public Builder setHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public CharacterProduct build() {
            return new CharacterProduct(this);
        }
    }
}

