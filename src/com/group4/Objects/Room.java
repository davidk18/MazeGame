package com.group4.Objects;

import com.group4.Builder.trapBuilder;
import com.group4.Interfaces.Item;
import com.group4.Interfaces.MapSite;
import com.group4.Prototype.CharacterPrototype;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private final int roomNr;
    private final MapSite northSide;
    private final MapSite southSide;
    private final MapSite westSide;
    private final MapSite eastSide;
    private ArrayList<Item> items;
    private List<CharacterPrototype> characters;
    private trapBuilder trap;
    private CharacterPrototype enemy;

    public Room(Builder builder) {
//        _roomNr = _roomCnt++;
//        System.out.println("creating Room #" + _roomNr);
        this.items = builder.items;
        this.roomNr = builder.roomNr;
        this.northSide = builder.northSide;
        this.southSide = builder.southSide;
        this.westSide = builder.westSide;
        this.eastSide = builder.eastSide;
        this.characters = builder.characters;
    }


    public MapSite getSide(Direction d) {
        MapSite result = null;
        if (d == Direction.North) {
            result = northSide;
        } else if (d == Direction.South) {
            result = southSide;
        } else if (d == Direction.East) {
            result = eastSide;
        } else if (d == Direction.West) {
            result = westSide;
        }
        return result;
    }

    public String toString() {
        return "Room #" + Integer.toString(roomNr);
    }

    public int getRoomNr() { return  roomNr; }

    public List<CharacterPrototype> getCharacters() {
        return characters;
    }

    public void displayItemsInRoom(){
        System.out.println("Items in room: ");
        for (int i = 0; i < items.size(); i++){
            System.out.println(i+1 + ") " + items.get(i).getShortDescription() + " (Damage=" + items.get(i).getDamage() + ")");
        }
        System.out.println();
    }

    public int getItemCount(){
        return items.size();
    }

    public void addItemToRoom(Item item, int itemIndex){
        items.add(itemIndex-1, item);
    }

    public Item takeItemFromRoom(int itemIndex){
        try {
            Item item = items.get(itemIndex - 1);
            items.remove(itemIndex - 1);
            return item;
        }
        catch (Exception e){
            return null;
        }
    }


    public trapBuilder addTrap(trapBuilder trap1) {
        this.trap = trap1;
        return trap1;
    }

    public trapBuilder getTrap(){
        return this.trap;
    }

    public CharacterPrototype addEnemy(CharacterPrototype clonedEnemy)
    {
        this.enemy = clonedEnemy;
        return clonedEnemy;
    }
    public CharacterPrototype getEnemy(){
        return this.enemy;
    }

    public CharacterPrototype removeEnemy()
    {
        this.enemy = null;
        return null;
    }

    public static class Builder {
        private final int roomNr;
        private static int roomCnt = 1;
        private MapSite northSide;
        private MapSite southSide;
        private MapSite westSide;
        private MapSite eastSide;
        private ArrayList<Item> items;
        private List<CharacterPrototype> characters;


        public  Builder() {
            roomNr = roomCnt++;
            characters = new ArrayList<>();
        }

        private Builder(MapSite n, MapSite s, MapSite w, MapSite e) {
            roomNr = roomCnt++;
            characters = new ArrayList<>();
            northSide = n;
            southSide = s;
            westSide = w;
            eastSide = e;
        }

        public Builder setNorth(MapSite site) {
            northSide = site;
            return this;
        }

        public Builder setSouth(MapSite site) {
            southSide = site;
            return this;
        }

        public Builder setWest(MapSite site) {
            westSide = site;
            return this;
        }

        public Builder setEast(MapSite site) {
            eastSide = site;
            return this;
        }

        public Builder addItemsToRoom(ArrayList<Item> items){
            this.items = items;
            return this;
        }

        public Builder addCharacter(CharacterPrototype character) {
            characters.add(character);
            return this;
        }


        public Room build() {
            return new Room(this);
        }




    }
}



