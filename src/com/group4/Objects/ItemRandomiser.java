package com.group4.Objects;

import com.group4.Factory.BronzeWeaponFactory;
import com.group4.Factory.GoldWeaponFactory;
import com.group4.Interfaces.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemRandomiser {

    public static ArrayList<Item> assignItems(){
        Random random = new Random();
        int maxBronze = random.nextInt(5);
        int maxGold = random.nextInt(3);
        ArrayList<Item> items = new ArrayList<Item>();
        BronzeWeaponFactory bwf = new BronzeWeaponFactory();
        GoldWeaponFactory gwf = new GoldWeaponFactory();
        String[] weaponList = {"Shotgun", "Sword"};


        int randomIndex = 0;
        ArrayList<Item> roomItems = new ArrayList<Item>();
        for (int i = 0; i < maxBronze; i++){
            randomIndex = random.nextInt(weaponList.length);
            roomItems.add(bwf.getWeapon(weaponList[randomIndex]));
        }

        for (int i = 0; i < maxGold; i++){
            randomIndex = random.nextInt(weaponList.length);
            roomItems.add(gwf.getWeapon(weaponList[randomIndex]));
        }

        return roomItems;

    }
}
