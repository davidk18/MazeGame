package com.group4.Factory;


import com.group4.Interfaces.Weapon;
import com.group4.Objects.GoldShotgun;
import com.group4.Objects.GoldSword;

public class GoldWeaponFactory implements WeaponFactory {


    @Override
    public Weapon getWeapon(String itemName) {
        switch(itemName) {
            case "Shotgun":
                return new GoldShotgun();
            case "Sword":
                return new GoldSword();
            default:
                return null;
        }
    }

}
