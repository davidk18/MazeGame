package com.group4.Factory;

import com.group4.Interfaces.Weapon;
import com.group4.Objects.BronzeShotgun;
import com.group4.Objects.BronzeSword;

public class BronzeWeaponFactory implements WeaponFactory {

    @Override
    public Weapon getWeapon(String itemName) {
        switch(itemName) {
            case "Shotgun":
                return new BronzeShotgun();
            case "Sword":
                return new BronzeSword();
            default:
            return  null;
        }
    }
}
