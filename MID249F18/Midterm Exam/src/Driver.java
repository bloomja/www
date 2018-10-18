import java.util.ArrayList;
import java.util.HashMap;

public class Driver {
	
	private static ArrayList<Integer> allIDs;
	private static HashMap<Integer, Item> inventory;
	
	public static void main(String[] args) {
		
		fillInventory();
		System.out.println("========First Report!==========");
		report();
		addItem(100, new Computer("Sony"));
		System.out.println("========Second Report!==========");
		report();
		deleteItem(12);
		System.out.println("========Third Report!===========");
		report();
		System.out.println("========ID number 20!===========");
		search(20);
		
	}
	
	private static void report () {
		int numSonyComputers = 0;
		int numIBMComputers = 0;
		int numHPComputers = 0;
		int numSonyDisks = 0;
		int numIBMDisks = 0;
		int numHPDisks = 0;
		int numSonyOtherMedia = 0;
		int numIBMOtherMedia = 0;
		int numHPOtherMedia = 0;
		for (int id : allIDs) {
			Item item = inventory.get(id);
			if (item instanceof Computer) {
				if (((Computer)item).brand.equals("Sony")) {
					numSonyComputers++;
				} else if (((Computer)item).brand.equals("IBM")) {
					numIBMComputers++;
				} else if (((Computer)item).brand.equals("HP")) {
					numHPComputers++;
				}
			} else if (item instanceof Disk) {
				if (((Disk)item).brand.equals("Sony")) {
					numSonyDisks++;
				} else if (((Disk)item).brand.equals("IBM")) {
					numIBMDisks++;
				} else if (((Disk)item).brand.equals("HP")) {
					numHPDisks++;
				}
			} else if (item instanceof OtherMedia) {
				if (((OtherMedia)item).brand.equals("Sony")) {
					numSonyOtherMedia++;
				} else if (((OtherMedia)item).brand.equals("IBM")) {
					numIBMOtherMedia++;
				} else if (((OtherMedia)item).brand.equals("HP")) {
					numHPOtherMedia++;
				}
			}
		}
		System.out.println("There are "+numSonyComputers+" Sony computers in stock!");
		System.out.println("There are "+numIBMComputers+" IBM computers in stock!");
		System.out.println("There are "+numHPComputers+" HP computers in stock!");
		System.out.println("There are "+numSonyDisks+" Sony disks in stock!");
		System.out.println("There are "+numIBMDisks+" IBM disks in stock!");
		System.out.println("There are "+numHPDisks+" HP disks in stock!");
		System.out.println("There are "+numSonyOtherMedia+" Sony other media devices in stock!");
		System.out.println("There are "+numIBMOtherMedia+" IBM other media devices in stock!");
		System.out.println("There are "+numHPOtherMedia+" HP other media devices in stock!");
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
