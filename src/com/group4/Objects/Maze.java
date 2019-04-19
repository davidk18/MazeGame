package com.group4.Objects;

import com.group4.Interfaces.IMaze;

import java.util.ArrayList;
import java.util.List;

public class Maze implements IMaze {

    private List<Room> rooms;
    private String map;

    public Maze(String map) {
        rooms = new ArrayList<>();
        this.map = map;
    }

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public String getMap(Room r) {
        String currentMap = "";
        for(int i = 0; i < map.length(); i++) {
            if(map.charAt(i) == Integer.toString(r.getRoomNr()).charAt(0)) {
                currentMap = map.replace(map.charAt(i), 'X');
            }
        }
        return currentMap;
    }

    public void move(CharacterPrototype original) {
        try {
            Door door = (Door) original.getCurrentRoom().getSide(original.getDirectionChosen());
            if(door.getRoom1().equals(original.getCurrentRoom())) {
                original.setCurrentRoom(door.getRoom2());
            }
            else
            {
                original.setCurrentRoom(door.getRoom1());
            }
        } catch (ClassCastException e) {
            System.out.println("You tried to walk through a wall!");
        }
    }
}
