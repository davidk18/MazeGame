package com.group4.Objects;

import com.group4.Interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<Item>();

    public Inventory() {

    }

    public boolean addItem(Item item) {
        items.add(item);
        return true;
    }

    public Item findItemByStringIndex(String s){
        int index = -1;
        try{
            index = Integer.parseInt(s);
        }
        catch(Exception e){
            System.out.println("Error combining items");
        }
        return items.get(index-1);
    }

    public boolean removeItem(Item item) {
        items.remove(item);
        return true;
    }

    public void display(){
        System.out.println("Player Inventory: ");
        for (int i = 0; i < items.size(); i++){
            System.out.println(i+1 + ") " + items.get(i).getShortDescription() + " (Damage=" + items.get(i).getDamage() + ")");
        }
    }

    public List<Item> getItems(){
        return items;
    }
}
