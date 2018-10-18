import java.util.ArrayList;
import java.util.HashMap;

public class Driver {
	
	private static ArrayList<Integer> allIDs;
	private static HashMap<Integer, Item> inventory;
	
	public static void main(String[] args) {
		
		fillInventory();
		
		
	}
	
	private static void report (String brand) {
		
	}
	
	private static void report (Item i) {
		for (int id : allIDs) {
			Item item = inventory.get(id);
			if (item.equals(i)) {
				
			}
		}
	}
	
	private static void report () {
		int numComputers = 0;
		int numDisks = 0;
		int numOtherMedia = 0;
		for (int id : allIDs) {
			Item item = inventory.get(id);
			if (item instanceof Computer) {
				numComputers++;
			} else if (item instanceof Disk) {
				numDisks++;
			} else if (item instanceof OtherMedia) {
				numOtherMedia++;
			}
		}
		System.out.println("There are "+numComputers+" computers in stock!");
		System.out.println("There are "+numDisks+" disks in stock!");
		System.out.println("There are "+numOtherMedia+" other media devices in stock!");
	}
	
	private static Item search(int id) {
		if (inventory.containsKey(id)) {
			Item item = inventory.get(id);
			System.out.println(item);
			return item;
		} else {
			System.out.println("No item with ID "+id+" in our inventory. returning null.");
			return null;
		}
	}
	
	private static void deleteItem(int id) {
		if (inventory.containsKey(id)) {
			inventory.remove(id);
			for (int i = 0; i < allIDs.size(); i++) {
				if (allIDs.get(i) == id) {
					allIDs.remove(i);
				}
			}
		} else {
			System.out.println("No item with ID "+id+" in our inventory. Nothing deleted.");
		}
	}
	
	private static void addItem(int id, Item i) {
		if (inventory.containsKey(id)) {
			System.out.println("There is already an item in inventory with that ID. Item not added.");
		} else {
			allIDs.add(id);
			inventory.put(id, i);
		}
	}
	
	/*
	 * Fills the inventory HashMap with a bunch of different
	 * Items that can be found at the store.
	 */
	private static void fillInventory() {
		allIDs = new ArrayList<Integer>();
		inventory = new HashMap<Integer, Item>();
		addItem(1, new Computer("Sony"));
		addItem(2, new Computer("Sony"));
		addItem(3, new Computer("Sony"));
		addItem(4, new Computer("Sony"));
		addItem(5, new Computer("IBM"));
		addItem(6, new Computer("IBM"));
		addItem(7, new Computer("HP"));
		addItem(8, new Computer("HP"));
		addItem(9, new Computer("HP"));
		addItem(10, new Computer("HP"));
		addItem(11, new Computer("HP"));
		addItem(12, new Disk("Sony"));
		addItem(13, new Disk("Sony"));
		addItem(14, new Disk("Sony"));
		addItem(15, new Disk("IBM"));
		addItem(16, new Disk("IBM"));
		addItem(17, new Disk("IBM"));
		addItem(18, new Disk("IBM"));
		addItem(19, new Disk("HP"));
		addItem(20, new Disk("HP"));
		addItem(21, new Disk("HP"));
		addItem(22, new OtherMedia("Sony"));
		addItem(23, new OtherMedia("Sony"));
		addItem(24, new OtherMedia("IBM"));
		addItem(25, new OtherMedia("IBM"));
		addItem(26, new OtherMedia("HP"));
		addItem(27, new OtherMedia("HP"));
	}
	
}
