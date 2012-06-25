import java.util.ArrayList;

public class Inventory {

	private ArrayList<Item> stash;

	/**
	 * TODO
	 */
	public Inventory() {
		stash = new ArrayList<Item>();
	}
	
	/**
	 * Adds an item to the inventory.
	 * @param toAdd The item to be added to the inventory.
	 */
	public void addInventory(Item toAdd) {
		stash.add(toAdd);
	}
	
	/**
	 * Removes an item from the inventory.
	 * @param itemName The name of the item to be removed.
	 * @return Returns the item that was removed if it was found, else returns null.
	 */
	public Item removeInventory(String itemName) {
		Item temp = null;
		for(int i = 0; i < stash.size(); i++) {
			if(itemName.equals(stash.get(i).getName())) {
				temp = stash.get(i);
				stash.remove(stash.get(i));
			}
		}
		return temp;
	}
	
	/**
	 * TODO
	 * @param itemName
	 * @return
	 */
	public Item viewItem(String itemName) {
		Item temp = null;
		for(int i = 0; i < stash.size(); i++) {
			if (itemName.equals(stash.get(i).getName())) {
				temp = stash.get(i);
			}
		}
		return temp;
	}
	
	/**
	 * Checks for an item's name in the inventory and returns its description.
	 * @param itemName The name of the item to be checked for.
	 * @return Returns the description of the item if it is found, else null.
	 */
	public String getItemDesc(String itemName) {
		String temp = null;
		for(int i = 0; i < stash.size(); i++) {
			if(itemName.equals(stash.get(i).getName())) {
				temp = stash.get(i).getDesc();
			}
		}
		return temp;
	}
	
	/**
	 * Peeks into the player's current inventory.
	 * @return Returns a String containing the names of held items.
	 */
	public String viewInventory() {
		StringBuilder contents = new StringBuilder();
		for(int i = 0; i < stash.size(); i++) {
			contents.append("\n");
			contents.append(stash.get(i).getName());
		}
		return contents.toString();
	}
}