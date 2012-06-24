public class Location {

	// Member variables 
	private String roomTitle; 
	private String roomDescription; 
	private Exit northExit, southExit, eastExit, westExit;
	private Inventory locInv;

	/**
	 * Full constructor for a new Location.
	 * @param title
	 * @param description
	 */
	public Location( String title, String description) { 
		// Assign title + description 
		roomTitle = title; 
		roomDescription = description; 
		// Blank exits 
		northExit = null;
		southExit = null;
		eastExit = null;
		westExit = null;
		locInv = new Inventory();
	}
	
	// Exit setters
	
	/**
	 * Sets a new Exit in the north direction.
	 * @param newExit The new Exit.
	 */
	public void setNorth(Exit newExit) {
		northExit = newExit;
	}
	
	/**
	 * Sets a new Exit in the south direction.
	 * @param newExit The new Exit.
	 */
	public void setSouth(Exit newExit) {
		southExit = newExit;
	}
	
	/**
	 * Sets a new Exit in the east direction.
	 * @param newExit The new Exit.
	 */
	public void setEast(Exit newExit) {
		eastExit = newExit;
	}
	
	/**
	 * Sets a new Exit in the west direction.
	 * @param newExit The new Exit.
	 */
	public void setWest(Exit newExit) {
		westExit = newExit;
	}
	
	// Exit getters
	
	/**
	 * Returns the Exit in the north direction.
	 * @return The Exit in the north direction.
	 */
	public Location getNorth() {
		return northExit.getLeadsTo();
	}
	
	/**
	 * Returns the Exit in the south direction.
	 * @return The Exit in the south direction.
	 */
	public Location getSouth() {
		return southExit.getLeadsTo();
	}
	
	/**
	 * Returns the Exit in the east direction.
	 * @return The Exit in the east direction.
	 */
	public Location getEast() {
		return eastExit.getLeadsTo();
	}
	
	/**
	 * Returns the Exit in the west direction.
	 * @return The Exit in the west direction.
	 */
	public Location getWest() {
		return westExit.getLeadsTo();
	}
	
	/**
	 * Overridden toString() returns the room's title
	 * @return Returns the room's title.
	 */
	public String toString() { 
		return roomTitle; 
	}

	/**
	 * Getter for the room title.
	 * @return Returns location title .
	 */
	public String getTitle() { 
		return roomTitle; 
	}

	/**
	 * Setter for the roomTitle
	 * @param roomTitle The new title for the room.
	 */
	public void setTitle( String newRoomTitle ) { 
		roomTitle = newRoomTitle; 
	}

	/**
	 * Getter for the location description.
	 * @return Returns location description.
	 */
	public String getDescription() { 
		return roomDescription; 
	}

	/**
	 * Setter for the room's location.
	 * @param roomDescription The new description of the room.
	 */
	public void setDescription( String newRoomDescription ) {
		roomDescription = newRoomDescription; 
	}

	/**
	 * Getter for the location's inventory.
	 * @return Returns the location's inventory.
	 */
	public Inventory getInventory() {
		return locInv;
	} 
}