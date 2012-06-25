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

public class Exit {
	
	// Numerical codes
	public static final int UNDEFINED = 0;
	public static final int NORTH = 1;
	public static final int SOUTH = 2;
	public static final int EAST = 3;
	public static final int WEST = 4;
	
	// Not used:
	public static final int UP = 5;
	public static final int DOWN = 6;
	public static final int NORTHEAST = 7;
	public static final int NORTHWEST = 8;
	public static final int SOUTHEAST = 9;
	public static final int SOUTHWEST = 10;
	public static final int IN = 11;
	public static final int OUT = 12;
	
	// String codes
	public static final String[] dirName = {
		"UNDEFINED", "NORTH", "SOUTH", "EAST", "WEST",
		"UP", "DOWN",
		"NORTHEAST", "NORTHWEST", "SOUTHEAST", "SOUTHWEST",
		"IN", "OUT" };
	public static final String[] shortDirName = {
		"NULL", "N", "S", "E", "W", "U", "D",
		"NE", "NW", "SE", "SW", "I", "O" };
	
	// Member variables
	private Location leadsTo = null;
	private int direction;
	
	// Full name of direction eg SOUTHEAST
	private String directionName;
	
	// Shortened version of direction eg SE
	private String shortDirectionName;
	
	// Full constructor
	/**
	 * Full constructor for a new Exit.
	 * @param direction An integer representation of an exit direction.
	 * @param leadsTo The Location that the exit leads to.
	 */
	public Exit( int newDirection, Location newLeadsTo ) {
		direction = newDirection;
		
		// Assign direction names
		if (direction <= dirName.length )
			directionName = dirName[direction];
		if (direction <= shortDirName.length )
			shortDirectionName = shortDirName[direction];
		
		// Assign location
		leadsTo = newLeadsTo;
	}
	
	/**
	 * Returns a String containing the name of the Exit's direction.
	 */
	public String toString() {
		return directionName;
	}
	
	/**
	 * Sets a new direction name.
	 * @param dirname The new name of the direction.
	 */
	public void setDirectionName( String dirname ) {
		directionName = dirname;
	}
	
	/**
	 * Returns the direction name.
	 * @return The name of the direction.
	 */
	public String getDirectionName() {
		return directionName;
	}
	
	/**
	 * Assigns the short direction name.
	 * @param shortName The new short name for the direction.
	 */
	public void setShortDirectionName( String shortName ) {
		shortDirectionName = shortName;
	}
	
	/**
	 * Returns the short direction name.
	 * @return The short direction name.
	 */
	public String getShortDirectionName() {
		return shortDirectionName;
	}
	
	/**
	 * Assigns a new Location for the Exit to lead to.
	 * @param leadsTo The new Location for the exit to lead to.
	 */
	public void setLeadsTo( Location newLeadsTo ) {
		leadsTo = newLeadsTo;
	}
	
	/**
	 * Returns the Location that the Exit leads to.
	 * @return The Location that the Exit leads to.
	 */
	public Location getLeadsTo() {
		return leadsTo;
	}
}