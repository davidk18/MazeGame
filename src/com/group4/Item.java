package com.group4;

public class Item {
	
	private String description;
	private String longDescription;
    private int damage;
    private boolean isGun;
    private boolean isAmmo;
	
	public Item(String inDescription, int inDamage, boolean inIsGun) {
		description = inDescription;
		damage = inDamage;
		isGun = inIsGun;
		isAmmo = false;
	}
	
	public String getShortDescription()
	{
		return description;
	}

	public String getLongDescription()
	{
		return " item(s), " + description + ".\n";
	}

	public boolean getIsGun() {
		return isGun;
	}

	public boolean getIsAmmo() {
		return isAmmo;
	}

	public int getDamage() {
		return damage;
	}

	public void isAmmo() {
		isAmmo = true;
	}
}