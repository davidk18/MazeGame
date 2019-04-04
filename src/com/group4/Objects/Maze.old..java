//package com.group4;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Maze {
//
//	// Still translating this
//
//	private List<Room> rooms;
//    private Character player;
//    public Room currentRoom;
//    private int enemyNumber;
//
//	public Maze() {
//		createPlayer();
//		createRooms();
//		createItems();
//		createEnemies();
//	}
//
//	private void createPlayer() {
//		player = new Character("Player", false, 100);
//	}
//
//	private void createRooms()  {
//		Room a, b, c, d, e, f, g, h, i, j;
//
//		a = new Room("a");
//		b = new Room("b");
//		c = new Room("c");
//		d = new Room("d");
//		e = new Room("e");
//		f = new Room("f");
//		g = new Room("g");
//		h = new Room("h");
//		i = new Room("i");
//		j = new Room("j");
//
//		//             (N, E, S, W)
//		a.setExits(f, b, d, c);
//		b.setExits(null, null, null, a);
//		c.setExits(null, a, null, null);
//		d.setExits(a, e, null, i);
//		e.setExits(null, j, null, d);
//		f.setExits(null, g, a, h);
//		g.setExits(null, null, null, f);
//		h.setExits(null, f, null, null);
//		i.setExits(null, d, null, null);
//		j.setExits(null, null, null, e);
//
//		rooms = Arrays.asList(a, b, c, d, e, f, g, h, i, j);
//		currentRoom = a;
//	}
//
//	private void createItems() {
//		List<Item> items;
//		Item handgun, shotgun, rocketLauncher, knife, sword;
//		handgun = new Item("Handgun", 20, true);
//		shotgun = new Item("Shotgun", 60, true);
//		rocketLauncher = new Item("Rocket launcher", 100, true);
//		knife = new Item("Knife", 20, false);
//		sword = new Item("Sword", 35, false);
//		items = Arrays.asList(handgun, shotgun, rocketLauncher, knife, sword);
//		for(int i = 0; i < (int)(Math.random() % 6) + 4; i++) { // (random number betweeb 0 and 5) + 4... so range is 4-9
//			rooms.get((int)Math.random() % rooms.size()).addItem(items.get((int)Math.random() % items.size()));
//		}
//		Ammo ammo = new Ammo();
//		for(int i = 0; i < (int)(Math.random() % 3) + 1; i++) {
//			Item item = (Item)ammo;
//			rooms.get((int)Math.random() % rooms.size()).addItem(item);
//		}
//	}
//
//
//	private void createEnemies() {
//		enemyNumber = 0;
//		List<Character> enemies;
//		Character ninja, terrorist, troop, dog;
//		ninja = new Character("Ninja", true, 50);
//		ninja.setDamage(30);
//		terrorist = new Character("Terrorist", true, 70);
//		terrorist.setDamage(70);
//		troop = new Character("Troop", true, 70);
//		troop.setDamage(60);
//		dog = new Character("Dog", true, 30);
//		dog.setDamage(20);
//		enemies = Arrays.asList(ninja, terrorist, troop, dog);
//		List<Integer> roomsWithEnemies = new ArrayList<>();
//		int roomIndex;
//		boolean duplicates;
//		for(int i = 0; i < (int)(Math.random() % 3) + 2; i++) { // (random number between 0 and 2) + 2... so range is 2-4
//			duplicates = true;
//			while(duplicates) {
//				duplicates = false;
//				roomIndex = (int)(Math.random() % rooms.size());
//				for(int y = 0; y < roomsWithEnemies.size(); y++) {
//					if(roomIndex == roomsWithEnemies.get(y))
//						duplicates = true;
//				}
//				if(!duplicates) {
//					roomsWithEnemies.add(roomIndex);
//					rooms.get(roomIndex).addEnemy(enemies.get((int)(Math.random() * enemies.size())));
//					enemyNumber++;
//				}
//			}
//		}
//	}
//
//
//
//
//	public String go(String direction) {
//		//Make the direction lowercase
//		//transform(direction.begin(), direction.end(), direction.begin(),:: tolower);
//		//Move to the next room
//		String message = "";
//		Room nextRoom = currentRoom.nextRoom(direction);
//		if (nextRoom != null)
//			currentRoom = nextRoom;
//		else
//			message += "You tried to go past the map...\n";
//		message += currentRoom.longDescription();
//		return message;
//	}
//
//	public String teleport() {
//		currentRoom = currentRoom.randomRoom(rooms);
//		return currentRoom.longDescription();
//	}
//
//	public void take(String itemName) {
//		Item item = currentRoom.isItemInRoom(itemName);
//		if(item.getIsAmmo()) {
//			if(!player.getInventory().getHasAmmo())
//			player.getInventory().setAmmo((Ammo)item);
//            else
//			player.getInventory().addAmmo((Ammo)item);
//		}
//		else {
//			player.getInventory().addItem(item);
//			if(player.getInventory().getItems().size() == 1)
//			player.getInventory().setCurrentItem(0);
//		}
//	}
//
//	public String showMap() {
//
//		String map = "";
//		map += "[h] --- [f] --- [g]\n";
//		map += "            |         \n";
//		map += "            |         \n";
//		map += "[c] --- [a] --- [b]\n";
//		map += "            |         \n";
//		map += "            |         \n";
//		map += "[i] --- [d] --- [e] --- [j]\n";
//		int mapLength = map.length();
//
//		for(int i = 0; i < mapLength; i++) {
//			if(map.charAt(i) == currentRoom.shortDescription().charAt(0))
//				map = map.replace(map.charAt(i), 'X');
//		}
//		return map;
//	}
//
//	public Character getPlayer() {
//		return player;
//	}
//
//	public void attack() {
//		String message = "";
//		if(player.getInventory().getCurrentItem().getIsGun() && !player.getInventory().ammo.getIsEmpty()) {
//			currentRoom.enemies.get(0).lowerHealth(player.getInventory().getCurrentItem().getDamage());
//			player.getInventory().ammo.useAmmo();
//		}
//    else {
//			currentRoom.enemies.get(0).lowerHealth(player.getInventory().getCurrentItem().getDamage());
//		}
//	}
//
//	void enemyKilled() {
//		enemyNumber--;
//	}
//
//	int getEnemyNumber() {
//		return enemyNumber;
//	}
//}