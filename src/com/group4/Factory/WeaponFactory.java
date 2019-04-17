package com.group4.Factory;

import com.group4.Interfaces.Item;
import com.group4.Interfaces.Shotgun;
import com.group4.Interfaces.Sword;
import com.group4.Interfaces.Weapon;

public interface WeaponFactory {
    Weapon getWeapon(String itemName);
}
