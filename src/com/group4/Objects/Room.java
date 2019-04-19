package com.group4.Objects;

import com.group4.Interfaces.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private final int roomNr;
    private final MapSite northSide;
    private final MapSite southSide;
    private final MapSite westSide;
    private final MapSite eastSide;
    private Item item;
    private List<CharacterPrototype> characters;

    public Room(Builder builder) {
//        _roomNr = _roomCnt++;
//        System.out.println("creating Room #" + _roomNr);

        this.roomNr = builder.roomNr;
        this.northSide = builder.northSide;
        this.southSide = builder.southSide;
        this.westSide = builder.westSide;
        this.eastSide = builder.eastSide;
        this.item = builder.item;
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
        return "Room #" + new Integer(roomNr).toString();
    }

    public int getRoomNr() { return  roomNr; }

    public Item getItem() {
        return item;
    }

    public List<CharacterPrototype> getCharacters() {
        return characters;
    }




    public static class Builder {
        private final int roomNr;
        private static int roomCnt = 1;
        private MapSite northSide;
        private MapSite southSide;
        private MapSite westSide;
        private MapSite eastSide;
        private Item item;
        private List<CharacterPrototype> characters;

//
//        public  Builder() {
//            roomNr = roomCnt++;
//            characters = new ArrayList<>();
//        }

        public Builder(MapSite n, MapSite s, MapSite w, MapSite e) {
            roomNr = roomCnt++;
            characters = new ArrayList<>();
            northSide = n;
            southSide = s;
            westSide = w;
            eastSide = e;
        }

//        public Builder setNorth(MapSite site) {
//            if(isDoor(site)) {
//
//            }
//            northSide = site;
//            return this;
//        }
//
//        public Builder setSouth(MapSite site) {
//            southSide = site;
//            return this;
//        }
//
//        public Builder setWest(MapSite site) {
//            westSide = site;
//            return this;
//        }
//
//        public Builder setEast(MapSite site) {
//            eastSide = site;
//            return this;
//        }

        public Builder setItem(Item item){
            this.item = item;
            return this;
        }

        public Builder addCharacter(CharacterPrototype character) {
            characters.add(character);
            return this;
        }

        private boolean isDoor(MapSite site) {
            if(site instanceof  Door) {
                return true;
            }
            return false;
        }


        public Room build() {
            return new Room(this);
        }





    }
}



