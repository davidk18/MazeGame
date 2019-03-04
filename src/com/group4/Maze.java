package com.group4;

import java.util.Arrays;
import java.util.List;

public class Maze {

	// Still translating this
	
	private List<Room> rooms;
    private Character player;
    public Room currentRoom;
    private int enemyNumber;
	
	public Maze() {
		createPlayer();
		createRooms();
		createItems();
		createEnemies();
	}
	
	private void createPlayer() {	
		player = new Character("Player", false, 100);
	}
	
	
	private void createRooms()  {
		Room a, b, c, d, e, f, g, h, i, j;

		a = new Room("a");
		b = new Room("b");
		c = new Room("c");
		d = new Room("d");
		e = new Room("e");
		f = new Room("f");
		g = new Room("g");
		h = new Room("h");
		i = new Room("i");
		j = new Room("j");

	//             (N, E, S, W)
		a.setExits(f, b, d, c);
		b.setExits(null, null, null, a);
		c.setExits(null, a, null, null);
		d.setExits(a, e, null, i);
		e.setExits(null, j, null, d);
		f.setExits(null, g, a, h);
		g.setExits(null, null, null, f);
		h.setExits(null, f, null, null);
		i.setExits(null, d, null, null);
		j.setExits(null, null, null, e);

		rooms = Arrays.asList(a, b, c, d, e, f, g, h, i, j);
		currentRoom = a;
	}

	private void createItems() {
		List<Item> items;
		Item handgun, shotgun, rocketLauncher, knife, sword;
		handgun = new Item("Handgun", 20, true);
		shotgun = new Item("Shotgun", 60, true);
		rocketLauncher = new Item("Rocket launcher", 100, true);
		knife = new Item("Knife", 20, false);
		sword = new Item("Sword", 35, false);
		items = Arrays.asList(handgun, shotgun, rocketLauncher, knife, sword);
		for(int i = 0; i < (int)(Math.random() % 6) + 4; i++) { // (random number betweeb 0 and 5) + 4... so range is 4-9
			rooms.get((int)Math.random() % rooms.size()).addItem(items.get((int)Math.random() % items.size()));
		}
		Ammo ammo = new Ammo();
		for(int i = 0; i < (int)(Math.random() % 3) + 1; i++) {
			Item item = (Item)ammo;
			rooms.get((int)Math.random() % rooms.size()).addItem(item);
		}
	}


	private void createEnemies() {
		enemyNumber = 0;
		List<Character> enemies;
		Character ninja, terrorist, troop, dog;
		ninja = new Character("Ninja", true, 50);
		ninja.setDamage(30);
		terrorist = new Character("Terrorist", true, 70);
		terrorist.setDamage(70);
		troop = new Character("Troop", true, 70);
		troop.setDamage(60);
		dog = new Character("Dog", true, 30);
		dog.setDamage(20);
		enemies = Arrays.asList(ninja, terrorist, troop, dog);
		List<Integer> roomsWithEnemies;
		int roomIndex;
		boolean duplicates;
		for(int i = 0; i < (rand() % 3) + 2; i++) { // (random number between 0 and 2) + 2... so range is 2-4
			duplicates = true;
			while(duplicates) {
				duplicates = false;
				roomIndex = rand() % rooms.size();
				for(int y = 0; y < roomsWithEnemies.size(); y++) {
					if(roomIndex == roomsWithEnemies[y])
						duplicates = true;
				}
				if(!duplicates) {
					roomsWithEnemies.push_back(roomIndex);
					rooms[roomIndex]->addEnemy(enemies[rand() % enemies.size()]);
					enemyNumber++;
				}
			}
		}
	}
	
}