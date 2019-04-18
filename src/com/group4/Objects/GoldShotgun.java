package com.group4.Objects;

import com.group4.Interfaces.Enchantment;
import com.group4.Interfaces.Weapon;

public class GoldShotgun implements Weapon {

    private boolean isGun;
    private int damage;
    private Ammo ammo;

    public GoldShotgun()
    {
        isGun = true;
        damage = 80;
        ammo = new Ammo();
    }
    @Override
    public int getDamage() {
        return damage;
    }

//    @Override
    public Ammo getAmmo() {
        return ammo;
    }

//    @Override // return true if shot fired, false if not (no ammo left)
    public boolean fire() {
        if(!ammo.getIsEmpty()) {
            ammo.useAmmo();
            return true;
        }
        else {
            return false;
        }
    }

//    @Override
    public void addAmmo(int a) {
        ammo.addAmmo(a);
    }

    @Override
    public Enchantment getEnchantment() {
        return null;
    }

    @Override
    public String getShortDescription() {
        return "Gold Shotgun";
    }

    @Override
    public String getLongDescription() {
        return getShortDescription() + " with " + ammo.getAmmo() + " bullets left.";
    }

    @Override
    public boolean getIsGun() {
        return isGun;
    }

    @Override
    public boolean getIsAmmo() {
        return false;
    }
}
