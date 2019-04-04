package com.group4.Factory;

import com.group4.Interfaces.Shotgun;
import com.group4.Interfaces.Sword;
import com.group4.Objects.BronzeShotgun;
import com.group4.Objects.BronzeSword;

public class BronzeWeaponFactory implements WeaponFactory {
    @Override
    public Shotgun getShotgun() {
        return new BronzeShotgun();
    }

    @Override
    public Sword getSword() {
        return new BronzeSword();
    }
}
