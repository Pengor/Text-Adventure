import java.util.Scanner;

public class Game {

	private static Scanner keyboard, inputRead;
	private static Location currentLoc;
	private static Player mainChar;
	private static String userInput, command, thing1, thing2;
	private static boolean gameOver;
	
	// Event booleans
	private static Boolean drawerOpened, hatchUnlocked;
	
	public static void main(String[] args) {
		
		keyboard = new Scanner(System.in);
		gameOver = false;
		
		// Setup Player
		mainChar = new Player("Rombitz", 72, "That's me, devilishly handsome.");
		
		// Starting values for event booleans
		drawerOpened = false;
		hatchUnlocked = false;
		
		// Setup Locations and Exits
		Location escapePod = new Location("Escape Pod", "I'm standing in the used NLX42 Cruiser escape pod that came from my ship.\nI have to get back there to find out what happened to it!\nThere is a drawer here and an exit hatch to the EAST.");
		Location prairie = new Location("Prairie", "A barren looking prairie, there are paths leading to the NORTH, EAST, and SOUTH.\nMy escape pod landed just WEST of here.");
		Location cliff = new Location("Cliff", "I'm standing on the edge of a cliff, there's a river far below and a suspicious looking rock lying near my feet.\nA path leads back to the prairie in the NORTH.");
		Location ranch = new Location("Ranch", "An elderly man is watching me cautiously from the shade of a tree.\nIt looks like this is some sort of farm or ranch.\nI can return to the prairie to the SOUTH.");
		Location busStop1 = new Location("Prairie Bus Stop", "There's a bench and a signpost with a bus painted on it here next to a road that streches endlessly in either direction.\nThere's a dirt path back to the prairie to the EAST.");
		
		
		prairie.setWest(new Exit(Exit.WEST, escapePod));
		
		prairie.setNorth(new Exit(Exit.NORTH, ranch));
		ranch.setSouth(new Exit(Exit.SOUTH, prairie));
		
		prairie.setSouth(new Exit(Exit.SOUTH, cliff));
		cliff.setNorth(new Exit(Exit.NORTH, prairie));
		
		prairie.setEast(new Exit(Exit.EAST, busStop1));
		busStop1.setWest(new Exit(Exit.WEST, prairie));
		
		// Setup items
		Item badge = new Item("badge", "My Milky Way Interplanetary Police and Investigative Bureau badge. It grants me a lot of priveleges. And almost as many free donuts.", true, true, false);
		Item iceCream = new Item("ice-cream", "Nevermelt brand Rocky Road ice cream. I've never been a fan of it myself, I've always found it's permanently gelatinous state a bit unnerving. I wonder how it got into that drawer...", true, true, null);
		Item hatchKey = new Item("hatch-key", "This should open the escape pod's exterior hatch, letting me get to the outside world. Wherever that might be...", true, true, hatchUnlocked);
		
		Item drawer = new Item("drawer", "A safety drawer designed to secure my belongings. Hopefully everything survived the atmospheric entry.", false, true, drawerOpened);
		escapePod.getInventory().addInventory(drawer);
		
		currentLoc = escapePod;
		
		System.out.println("\n===============================================================================");
		System.out.println("==  Rombitz: Galactic Investigator (Working Title) - Version 0.1.0           ==");
		System.out.println("==  Story and Programming by Drew Masterman Johnson                          ==");
		System.out.println("==  Software under GNU General Public License v3 - June 2012                 ==");
		System.out.println("===============================================================================");
		System.out.println("\nOur story takes place at an exciting time in our history, where intergalactic \n" +
						   "space travel is in its infancy. Travel between planetary systems, however, is \n" +
						   "both common and an integral part of the Milky Way's economy. The people of \n" +
						   "Earth have expanded and colonized deep into the galaxy, encountering new \n" +
						   "intelligent lifeforms along the way. The task of enforcing the laws of our \n" +
						   "united galaxy falls upon the Milky Way Interplanetary Police and Investigation \n" +
						   "Bureau, or more commonly as the Mwips. I am Investigator Rombitz, a veteran \n" +
						   "Mwips detective and I need your help to solve what could prove to be my most \n" +
						   "difficult case yet. Why do I need your help? Well while I was in transit to \n" +
						   "the crime scene, I was ambushed by an unknown attacker and forced to use an \n" +
						   "escape pod. For some reason the attackers left as soon as I ejected, they may \n" +
						   "have just been trying to shake me up. Firstly, I need to get back to my ship \n" +
						   "before I can continue the case.\n");
		System.out.println("===============================================================================\n");
		System.out.println(currentLoc.getTitle());
		System.out.println(currentLoc.getDescription());
		do {
			// Reset user values
			userInput = "";
			command = "";
			thing1 = "";
			thing2 = "";
			
			// Read user input
			if (keyboard.hasNextLine())
				userInput = keyboard.nextLine();
			inputRead = new Scanner(userInput);
			if (inputRead.hasNext())
				command = inputRead.next().toLowerCase();
			if (inputRead.hasNext())
				thing1 = inputRead.next().toLowerCase();
			if (inputRead.hasNext())
				thing2 = inputRead.next().toLowerCase();
			
			// Actions
			if (command.equals("help"))
				Action.help();
			else if (command.equals("inventory"))
				Action.inven();
			else if (command.equals("talk")) {
				//Action.talk();
				System.out.println("You cannot talk to people yet in this version.");
			}
			else if (command.equals("take"))
				Action.take(thing1);
			else if (command.equals("use"))
				Action.use(thing1);
			else if (command.equals("combine")) {
				//Action.combine();
				System.out.println("You cannot combine items yet in this version.");
			}
			else if (command.equals("go"))
				Action.go(thing1);
			else if (command.equals("examine"))
				Action.examine(thing1);
			else if (command.equals("exit"))
				Action.exit();
			else
				System.out.println("I don't understand you. Type help to see usable commands.");
			
			
			// Events - boolean toggles
			// Update drawerOpened
			drawerOpened = drawer.getEventToggle();
			if (drawerOpened) {
				drawerOpened = false;
				drawer.toggleEventToggle();
				
				escapePod.getInventory().addInventory(badge);
				escapePod.getInventory().addInventory(iceCream);
				escapePod.getInventory().addInventory(hatchKey);
				System.out.println("The drawer slides open, revealing my badge, a tub of ice-cream, and the hatch-key. I'll definitely need two of these three items.");
				drawer.setDesc("I've opened the drawer already, it has no further use.");
			}
			
			hatchUnlocked = hatchKey.getEventToggle();
			if (hatchUnlocked) {
				hatchUnlocked = false;
				hatchKey.toggleEventToggle();
				
				escapePod.setEast(new Exit(Exit.EAST, prairie));
				System.out.println("The chamber depressurizes and I unlock the door. The fact that I didn't suffocate means it's probably safe for me to go outside.");
				if (mainChar.getInventory().viewItem("hatch-key") != null)
					mainChar.getInventory().removeInventory("hatch-key");
			}
			
			
		} while(!gameOver);
		System.out.println("Thank you for playing, you may now close the window.");
	}
	
	/**
	 * Gets the current location of the game.
	 * @return Returns the current Location of the game.
	 */
	public static Location getLocation() {
		return currentLoc;
	}
	
	/**
	 * Sets the current location.
	 * @param newLoc The new location for the game.
	 */
	public static void setLocation(Location newLoc) {
		currentLoc = newLoc;
	}

	/**
	 * Getter for thing1 String.
	 * @return Returns copy of thing1;
	 */
	public static String getThing1() {
		return thing1;
	}
	
	/**
	 * Getter for thing2 String.
	 * @return Returns copy of thing2;
	 */
	public static String getThing2() {
		return thing2;
	}

	/**
	 * Sets the Game.gameOver boolean to true, which ends the program.
	 */
	public static void setGameOver() {
		gameOver = true;
	}
	
	/**
	 * Gets the Player object from the Game class.
	 * @return The Game's Player.
	 */
	public static Player getPlayer() {
		return mainChar;
	}
}