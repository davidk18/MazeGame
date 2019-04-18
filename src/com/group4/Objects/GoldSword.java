package com.group4.Objects;

import com.group4.Interfaces.Enchantment;
import com.group4.Interfaces.Weapon;

public class GoldSword implements Weapon {

    private int damage;
    private Enchantment enchantment;

    public GoldSword(Enchantment enchantment) {
        this.enchantment = enchantment;
        damage = 40;
    }

    public GoldSword() {
        damage = 40;
    }

    @Override
    public int getDamage() {
        return damage;
    }


    public void enchantedDamage(){
        enchantment.apply();
        System.out.println("enchantment applied");
        damage *= 2;
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

    @Override
    public Enchantment getEnchantment(){
        return enchantment;
    }
}
