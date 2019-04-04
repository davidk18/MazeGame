package com.group4.Objects;

import com.group4.Interfaces.Item;

public class Ammo implements Item {

	private int amountOfAmmo;
    private boolean isEmpty;
	private boolean isAmmo;

	public Ammo() {
		amountOfAmmo = 0;
		addAmmo((int)(Math.random() % 10) + 1);
		isEmpty = false;
		isAmmo = true;
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

	@Override
	public String getShortDescription() {
		return "Ammo";
	}

	@Override
	public String getLongDescription() {
		return "Ammo with " + amountOfAmmo + " bullets left";
	}

	@Override
	public boolean getIsGun() {
		return false;
	}

	@Override
	public boolean getIsAmmo() {
		return isAmmo;
	}
}