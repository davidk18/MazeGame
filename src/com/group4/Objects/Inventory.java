//package com.group4.Objects;
//
//import java.util.List;
//
//public class Inventory {
//
//	private List<Item> items;
//    private Item currentItem;
//    private boolean hasAmmo;
//    public Ammo ammo;
//
//	public Inventory()
//	{
//		hasAmmo = false;
//	}
//
//	public void addItem(Item item) {
//		items.add(item);
//	}
//
//	public List<Item> getItems() {
//		return items;
//	}
//
//	public void setCurrentItem(int i) {
//		currentItem = items.get(i);
//	}
//
//	public Item getCurrentItem() {
//		return currentItem;
//	}
//
//	public void setAmmo(Ammo inAmmo) {
//		ammo = inAmmo;
//		hasAmmo = true;
//	}
//
//	public Ammo getAmmo() {
//		return ammo;
//	}
//
//	public boolean getHasAmmo() {
//		return hasAmmo;
//	}
//
//	public void addAmmo(Ammo inAmmo) {
//		ammo.addAmmo(inAmmo.getAmmo());
//	}
//}