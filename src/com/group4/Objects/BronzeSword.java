package com.group4.Objects;

import com.group4.Interfaces.Enchantment;
import com.group4.Interfaces.Weapon;

import java.util.Random;

public class BronzeSword implements Weapon {

    private int damage;
    private Enchantment enchantment;

    public BronzeSword(Enchantment enchantment) {
        this.enchantment = enchantment;
        damage = DamageRandomiser.getRandomDamage(20, 30);
    }

    public BronzeSword() {
        damage = DamageRandomiser.getRandomDamage(20, 30);
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage){
        this.damage = damage;
    }

    public void enchantedDamage(){
        enchantment.apply();
        System.out.println("enchantment applied");
        damage *= 2;
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

    @Override
    public Enchantment getEnchantment(){
        return enchantment;
    }
}
