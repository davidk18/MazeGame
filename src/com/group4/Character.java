package com.group4;

public class Character {
	
	private String description;
    private Inventory inventory;
    private boolean isEnemy;
    private boolean isAlive;
    private int health;
    private int damage;
	
	public Character(String description, boolean isEnemy, int health) {
		this.description = description;
		this.isEnemy = isEnemy;
		if(!isEnemy)
			inventory = new Inventory();
		this.health = health;
		isAlive = true;
	}
	
	public String shortDescription() {
		return description;
	}

	public String longDescription()
	{
	  String ret = this.description;
	  return ret;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public int getHealth() {
		return health;
	}

	public void lowerHealth(int hitDamage) {
		this.health -= hitDamage;
		if(health <= 0) {
			isAlive = false;
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public boolean getIsEnemy() {
		return isEnemy;
	}

	public boolean getIsAlive() {
		return isAlive;
	}
	
}