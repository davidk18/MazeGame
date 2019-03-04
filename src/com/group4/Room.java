package com.group4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Room {

	private String description;
	private Map<String, Room> exits;
    private List<Item> itemsInRoom;
    private boolean enemyPresent;
    public List<Character> enemies;

	public Room(String description) {
		this.description = description;
		enemyPresent = false;
		exits = new LinkedHashMap<>();
		itemsInRoom = new ArrayList<>();
		enemies = new ArrayList<>();
	}


	public void setExits(Room north, Room east, Room south, Room west) {
		if (north != null)
			exits.put("north", north);
		if (east != null)
			exits.put("east", east);
		if (south != null)
			exits.put("south", south);
		if (west != null)
			exits.put("west", west);
	}

	public String shortDescription() {
		return description;
	}

	public String longDescription() {
		if(getEnemyPresent()){
			return "room = " + description + ".\n" + displayItem() + "\n" + "Enemy in room: " + enemies.get(0).shortDescription() + exitString();
		}
		else
			return "room = " + description + ".\n" + displayItem() + "\n" + "No enemies in room" + exitString();
	}

	public String exitString() {
		String returnString = "\nexits =";
		for (Map.Entry entry : exits.entrySet()) {
			returnString += "  " + entry.getKey();	// access the "first" element of the pair (direction as a string)
		}
		return returnString;
	}

	public Room nextRoom(String direction) {
		//Iterator next = exits.entrySet().iterator();
		Room next = exits.get(direction); //returns an iterator for the "pair"
		if (next != null) // if not null, there is a room
			return next;  // return next room
		return null; // return null if there is no room
	}

	public Room randomRoom(List<Room> rooms) {
		boolean success = false;
		while(!success) {
			int i = (int)(Math.random() * rooms.size());
			if(this.description != rooms.get(i).shortDescription()) {
			   return rooms.get(i);
			}
		}
		return null;
	}

	public void addItem(Item inItem) {
		//cout <<endl;
		//cout << "Just added" + inItem->getLongDescription();
		itemsInRoom.add(inItem);
	}

	public List<Item> getItems() {
		return itemsInRoom;
	}

	public String displayItem() {
		String tempString = "items in room = ";
		int sizeItems = (itemsInRoom.size());
		if (itemsInRoom.size() < 1) {
			tempString = "no items in room";
			}
		else if (itemsInRoom.size() > 0) {
		    int x = (0);
		    for (int n = sizeItems; n > 0; n--) {
				tempString = tempString + itemsInRoom.get(n).getShortDescription() + "  " ;
				x++;
			}
		}
		return tempString;
	}

	public int numberOfItems() {
		return itemsInRoom.size();
	}

	public Item isItemInRoom(String inString)
	{
		int sizeItems = (itemsInRoom.size());
		if (itemsInRoom.size() > 0) {
		    int x = (0);
			for (int n = sizeItems; n > 0; n--) {
				// compare inString with short description
				boolean tempFlag = inString.equals(itemsInRoom.get(x).getShortDescription());
				if (tempFlag) {
					Item item = itemsInRoom.get(x);
					//itemsInRoom.erase(itemsInRoom.begin()+x);
					return item;
				}
				x++;
			}
		}
		return null;
	}

	public void addEnemy(Character enemy) {
		enemies.add(enemy);
	//    this->enemy = enemy;
		enemyPresent = true;
	}

	public boolean getEnemyPresent() {
		return enemyPresent;
	}

	//vector<Character*> Room::getEnemies() {
	//    return enemies;
	//}


	public void killEnemy() {
		enemies.remove(0);
		enemyPresent = false;
	//    delete enemy;
	}

}