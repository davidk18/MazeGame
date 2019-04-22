package com.group4.Factory;


import com.group4.Interfaces.Weapon;
import com.group4.Objects.GoldShotgun;
import com.group4.Objects.GoldSword;

import java.util.HashMap;
import java.util.Map;

public class GoldWeaponFactory implements WeaponFactory {


    private Map<String, Weapon> weapons = new HashMap<String, Weapon>() {
        {
            put("Shotgun", new GoldShotgun());
            put("Sword", new GoldSword());

        }
    };

    @Override
    public Weapon getWeapon(String itemName) {
        return weapons.get(itemName);

    }

}
