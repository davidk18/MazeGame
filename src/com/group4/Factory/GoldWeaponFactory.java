package com.group4.Factory;

import com.group4.Interfaces.Shotgun;
import com.group4.Interfaces.Sword;
import com.group4.Objects.GoldShotgun;
import com.group4.Objects.GoldSword;

public class GoldWeaponFactory implements WeaponFactory {

    @Override
    public Shotgun getShotgun() {
        return new GoldShotgun();
    }

    @Override
    public Sword getSword() {
        return new GoldSword();
    }
}
