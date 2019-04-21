package com.group4;

import com.group4.Command.GameState;
import com.group4.Command.LocalGameStateManager;
import com.group4.Command.MazeMoveCommand;
import com.group4.Factory.SimpleWeaponFactory;
import com.group4.Factory.WeaponFactory;
import com.group4.Interfaces.IMaze;
import com.group4.Interfaces.MazeBuilder;
import com.group4.Interfaces.Weapon;
import com.group4.Interpreter.Combiner;
import com.group4.Objects.*;
import com.group4.Interceptor.ConcreteFrameWork;

import java.util.Scanner;

public class Main {
//fuck you git
    private Maze maze;

    public static void main(String[] args) throws CloneNotSupportedException {
//        TestCode();

//        A a = new A();
//        a.aText = "First text";
//        System.out.println(a.aText);
//        B b = new B();
//        b.bText = "haha";
//        b.a = a;
//        System.out.println(b.a.aText);
//        a.aText = "Test text";
//        System.out.println(a.aText);
//        System.out.println(b.a.aText);
//        a = new A();
//        a.aText = "-----------------------------";
//        b.a1 = a;
//        System.out.println(b.a.aText);
//        System.out.println(b.a1.aText);

        Game play = new Game();

        //test builder for trap
//        trapBuilder trap1 = new trapBuilder.Builder().setDescription("this trap covers any poor soul who stumbles upon it in flames").setTrapActive(true).setHasFire(true).build();
//        System.out.println("trap1: " + trap1);
//        System.out.println(trap1.getDescription());


    }
}
