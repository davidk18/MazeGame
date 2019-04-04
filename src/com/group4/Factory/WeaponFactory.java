package com.group4.Factory;

import com.group4.Interfaces.Shotgun;
import com.group4.Interfaces.Sword;

public interface WeaponFactory {
    Shotgun getShotgun();
    Sword getSword();
//    Item getItem(Item item);
}
