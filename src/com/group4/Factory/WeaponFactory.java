package com.group4.Factory;

import com.group4.Interfaces.Weapon;

public interface WeaponFactory {
    Weapon getWeapon(String itemName);
}
