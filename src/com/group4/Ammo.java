package com.group4;

public class Ammo extends Item {
	
	private int amountOfAmmo;
    private boolean isEmpty;
	
	public Ammo()  {
		super("Ammo", 0, false);
		isAmmo();
	}
	
	public Ammo(Item item) {
		super("Ammo", 0, false);
		isAmmo();
		amountOfAmmo = 0;
		addAmmo((int)(Math.random() % 10) + 1);
		isEmpty = false;
	}
	
	public void addAmmo(int inAmmo) {
		amountOfAmmo += inAmmo;
	}
	
	public int getAmmo() {
		return amountOfAmmo;
	}
	
	public void useAmmo() {
		if(amountOfAmmo > 0)
			amountOfAmmo--;
		if(amountOfAmmo == 0)
			isEmpty = true;
	}

	public boolean getIsEmpty() {
		return isEmpty;
	}
}