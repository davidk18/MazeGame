package com.group4.Objects;

import com.group4.Interfaces.Sword;

public class BronzeSword implements Sword {

    private int damage;

    public BronzeSword() {
        damage = 20;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getShortDescription() {
        return "Bronze Sword";
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
