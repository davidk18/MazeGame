package com.group4.Factory;

import com.group4.Interfaces.Weapon;
import com.group4.Objects.BronzeShotgun;
import com.group4.Objects.BronzeSword;


import java.util.HashMap;
import java.util.Map;

public class BronzeWeaponFactory implements WeaponFactory {

    private Map<String, Weapon> weapons = new HashMap<String, Weapon>() {
        {
            put("Shotgun", new BronzeShotgun());
            put("Sword", new BronzeSword());

        }
    };

    @Override
    public Weapon getWeapon(String itemName) {
        return weapons.get(itemName);
    }
}
