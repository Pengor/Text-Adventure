public class Action {
	
	//Help
	public static void help() {
		System.out.println("You can use any of the following commands:");
		System.out.println(
			"Inventory ----------------Lists the items in the inventory.\n" +
			"Talk <person>-------------Converse with a game character.\n" +
			"Take <item>---------------Add an item to your inventory.\n" +
			"Use <item>----------------Use an item in a room or your inventory.\n" +
			"Combine <item> <item>-----Combine two items to create a new item.\n" +
			"Go <cardinal direction>---Move your character to a different room.\n" +
			"Examine <person>----------Display a description of a character.\n" +
			"Examine <item>------------Display a description of an item.\n" +
			"Examine room--------------Display a description of your location.\n" +
			"Help----------------------Assists the player by showing this list.\n" +
			"Exit----------------------Ends the game. Progress will NOT be saved!");
	}
	
	//Inventory
	public static void inven() {
		System.out.print("I'm currently carrying:");
		if (Game.getPlayer().getInventory().viewInventory().length() > 0)
			System.out.print(Game.getPlayer().getInventory().viewInventory());
		else
			System.out.print("\nNothing!");
	}
	
		
	//Talk to <NPC>
	public void talk(Object obj) {
		;
	}
	
	//Take <Item>
	public static void take(String str) {
		//Algorithm:
		//  Check validity
		//  Add item to inventory
		//  Remove item from location
		//  Display message
		try {
			if (Game.getLocation().getInventory().viewItem(str).isTakable()) {
				Game.getPlayer().getInventory().addInventory(
						Game.getLocation().getInventory().removeInventory(str));
				Game.getPlayer().getInventory().viewItem(str).toggleTakable();
				System.out.println("I've picked up the " + Game.getThing1() 
						+ ".");
				
			}
			else
				System.out.println("I can't take this " + Game.getThing1() 
						+ " you speak of.");
		} catch (Exception e) {
			System.out.println("I tried to take that, but it didn't work.");
		}
	}
	
	//Use <Item>
	public static void use(String str) {
		//Algorithm:
		//  Check validity
		//  Display message
		//  If necessary, remove from inventory
		//  Perform corresponding action to location, NPC, etc.
		try {
			if (Game.getLocation().getInventory().viewItem(str).isUsable()) {
				Game.getLocation().getInventory().viewItem(str).toggleEventToggle();
			}
			else if (Game.getPlayer().getInventory().viewItem(str).isUsable()) {
				Game.getPlayer().getInventory().viewItem(str).toggleEventToggle();
			}
			else
				System.out.println("I don't think I can use that " + str + ".");
		} catch (Exception e) {
			System.out.println("I tried to use that, but some unseen cosmic forces prevented anything from happening.");
		}
	}
	
	//Combine <Item> <Item>
	public void combine(Object ob1, Object ob2) {
		//Algorithm:
		//  Check validity
		//  Remove items from inventory
		//  Create new item
		//  Add new item to inventory
		//  Display message
	}
	
	//Go <Direction>
	public static void go(String direction) {
		boolean roomChanged = false;
		// Check if direction is valid
		try {
			if (direction.equals("north") && Game.getLocation().getNorth() != null) {
				Game.setLocation(Game.getLocation().getNorth());
				roomChanged = true;
			}
			else if (direction.equals("south") && Game.getLocation().getSouth() != null) {
				Game.setLocation(Game.getLocation().getSouth());
				roomChanged = true;
			}
			else if (direction.equals("east") && Game.getLocation().getEast() != null) {
				Game.setLocation(Game.getLocation().getEast());
				roomChanged = true;
			}
			else if (direction.equals("west") && Game.getLocation().getWest() != null) {
				Game.setLocation(Game.getLocation().getWest());
				roomChanged = true;
			}

			// Give Room Intro or tell player otherwise
			if (roomChanged) {
				System.out.println(Game.getLocation().getTitle());
				System.out.println(Game.getLocation().getDescription());
			}
			else
				System.out.println("I can't go " + Game.getThing1() +".");
		} catch (Exception e)/*(NullPointerException e)*/ {
			System.out.println("I tried to go there, but I couldn't find it.");
		}
	}
	
	//Examine <Item>
	public static void examine(String str) {
		if (str.equals("room"))
			System.out.println(Game.getLocation().getDescription());
		else if (Game.getPlayer().getInventory().getItemDesc(str) != null)
			System.out.println(Game.getPlayer().getInventory().getItemDesc(str));
		else if (Game.getLocation().getInventory().getItemDesc(str) != null)
			System.out.println(Game.getLocation().getInventory().getItemDesc(str));
		else if (str.length() > 0)
			System.out.println("I can't examine this " + str + " you speak of.");
		else
			System.out.println("I tried to examine that, but I couldn't find it.");
	}

	public static void exit() {
		Game.setGameOver();
	}
		
}