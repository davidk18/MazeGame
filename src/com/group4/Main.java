package com.group4;

import com.group4.Factory.GoldWeaponFactory;
import com.group4.Factory.WeaponFactory;
import com.group4.Interfaces.Shotgun;
import com.group4.Objects.Maze;
import com.group4.Objects.MazeGame;

public class Main {

    public static void main(String[] args) {
        MazeGame game = new MazeGame();
        Maze maze = game.createMaze();

        WeaponFactory factory = new GoldWeaponFactory();
        Shotgun gun = factory.getShotgun();
        System.out.println(gun.getLongDescription());
    }
}
