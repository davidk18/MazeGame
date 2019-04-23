package com.group4.Objects;

import com.group4.Interfaces.Enchantment;
import com.group4.Interfaces.Weapon;

public class GoldShotgun implements Weapon {

    private boolean isGun;
    private int damage;

    public GoldShotgun()
    {
        isGun = true;
        damage = DamageRandomiser.getRandomDamage(40, 60);
    }
    @Override
    public int getDamage() {
        return damage;
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
        return getShortDescription();
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
