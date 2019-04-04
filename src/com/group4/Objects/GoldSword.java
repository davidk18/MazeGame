package com.group4.Objects;

import com.group4.Interfaces.Sword;

public class GoldSword implements Sword {

    private int damage;

    public GoldSword() {
        damage = 40;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getShortDescription() {
        return "Gold Sword";
    }

    @Override
    public String getLongDescription() {
        return getShortDescription();
    }

    @Override
    public boolean getIsGun() {
        return false;
    }

    @Override
    public boolean getIsAmmo() {
        return false;
    }
}
