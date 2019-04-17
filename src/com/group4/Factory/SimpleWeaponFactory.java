package com.group4.Factory;

public class SimpleWeaponFactory {
    public WeaponFactory getWeaponFactory(String factoryType) {
        switch(factoryType) {
            case "Gold":
                return new GoldWeaponFactory();
            case "Bronze":
                return new BronzeWeaponFactory();
            default:
                return null;
        }
    }
}
