package com.group4.Objects;

import com.group4.Interfaces.Enchantment;
import com.group4.Interfaces.Weapon;

import java.util.Random;

public class BronzeShotgun implements Weapon {

    private boolean isGun;
    private int damage;

    public BronzeShotgun()
    {
        isGun = true;
        damage = DamageRandomiser.getRandomDamage(10, 25);
    }
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public Enchantment getEnchantment() {
        System.out.println("notimplementedexcep");
        return null;
    }


    @Override
    public String getShortDescription() {
        return "Bronze Shotgun";
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
