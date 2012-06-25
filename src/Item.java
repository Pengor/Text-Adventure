/* 
 * Copyright 2012 Drew Johnson
 * 
 * This file is part of Rombitz.
 * 
 * Rombitz is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *  
 * Rombitz is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Rombitz.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.ArrayList;

public class Item {
	
	private String name;
	private String description;
	private boolean takable;
	private boolean usable;
	private Boolean eventToggle;
	private ArrayList<Item> combinables;
	
	/**
	 * Constructor for an item.
	 * @param newName The item's name.
	 * @param newDesc The item's description.
	 * @param canTake Whether or not the item is takable.
	 * @param canUse Whether or not the item is usable.
	 * @param newToggle An event Boolean corresponding to one in the Game class.
	 */
	public Item(String newName, String newDesc, boolean canTake, boolean canUse, Boolean newToggle) {
		name = newName;
		description = newDesc;
		takable = canTake;
		usable = canUse;
		combinables = new ArrayList<Item>();
		eventToggle = newToggle;
	}
	
	/**
	 * Add a new Item to the list of compatible items.
	 * @param newItem The item to be added to the list of combinable items.
	 */
	public void addUsableItem(Item newItem) {
		combinables.add(newItem);
	}
	
	/**
	 * Getter for the name String.
	 * @return The item's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the item's description.
	 * @return The String containing the description.
	 */
	public String getDesc() {
		return description;
	}
	
	/**
	 * Getter for the status of the takable boolean.
	 * @return The takable boolean value, true or false.
	 */
	public boolean isTakable() {
		return takable;
	}
	
	/**
	 * Getter for the status of the usable boolean.
	 * @return The usable boolean value, true or false.
	 */
	public boolean isUsable() {
		return usable;
	}
	
	/**
	 * If takable is true, set to false. Else set to true.
	 */
	public void toggleEventToggle() {
		if (eventToggle.booleanValue()) {
			eventToggle = false;
		}
		else {
			eventToggle = true;
		}
	}

	/**
	 * Sets a new value for the item's description.
	 * @param str The item's new description.
	 */
	public void setDesc(String str) {
		description = str;
	}
	
	/**
	 * Getter for the eventToggle Boolean.
	 * @return Returns the eventToggle Boolean object.
	 */
	public Boolean getEventToggle() {
		return eventToggle;
	}

	/**
	 * If takable is true, set to false. Else set to true.
	 */
	public void toggleTakable() {
		if (takable)
			takable = false;
		else
			takable = true;
	}
}