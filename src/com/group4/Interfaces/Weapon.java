package com.group4.Interfaces;

import com.group4.Objects.Ammo;

public interface Weapon extends Item{
    int getDamage();
//    Ammo getAmmo();
//    boolean fire();
//    void addAmmo(int a);
    Enchantment getEnchantment();
}
