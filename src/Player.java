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

public class Player {
	
	private String name;
	private int age;
	private String description;
	private Inventory playerInv;
	
	/**
	 * Full constructor for a new Player object.
	 * @param newName The player's name.
	 * @param newAge The player's age.
	 * @param desc A description of the player.
	 */
	public Player(String newName, int newAge, String desc) {
		name = newName;
		age = newAge;
		description = desc;
		playerInv = new Inventory();
	}

	// Getter methods
	
	/**
	 * Returns the name of the Player.
	 * @return The Player's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the age of the Player.
	 * @return The Player's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Returns the description of the player.
	 * @return The Player's description.
	 */
	public String getDesc() {
		return description;
	}

	/**
	 * Getter for the player's inventory.
	 * @return The player's inventory.
	 */
	public Inventory getInventory() {
		return playerInv;
	}

	// Setter methods

	/**
	 * Set a new description for the Player.
	 * @param newDesc The new description for the Player.
	 */
	public void setDesc(String newDesc) {
		description = newDesc;
	}
}