import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonDemo {
	
	private static ArrayList<Person> people;
	private static final String FILENAME = "src\\people.bin";
	private static ObjectInputStream inStream = null;
	private static ObjectOutputStream outStream = null;
	private static Date today;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter today's date formatted like September 27, 1999: ");
		String date = scan.nextLine();
		today = parseDate(date);
		System.out.println("Today's date is " + today);
		
		listCommands();
		String command = "";
		while (true) {
			System.out.print("Type 'list' to list the commands again \n> ");
			command = scan.nextLine();
			if (command.equals("load")) {
				readData();
			} else if (command.equals("save")) {
				writeData();
			} else if (command.equals("add")) {
				System.out.print("Enter the name of the person you would like to add: \n> ");
				String name = scan.nextLine();
				System.out.print("What month was that person born? \n> ");
				String birthMonth = scan.nextLine();
				System.out.print("What day of the month was that person born? \n> ");
				int birthDay = scan.nextInt();
				scan.nextLine(); // Purge the newline
				System.out.print("What year was that person born? \n> ");
				int birthYear = scan.nextInt();
				scan.nextLine(); // Purge the newline
				System.out.print("Is that person alive? (y/n) \n> ");
				String alive = scan.nextLine().toLowerCase();
				if (alive.equals("n") || alive.equals("no")) {
					System.out.print("What month did that person die? \n> ");
					String deathMonth = scan.nextLine();
					System.out.print("What day of the month did that person die? \n> ");
					int deathDay = scan.nextInt();
					System.out.print("What year did that person die? \n> ");
					int deathYear = scan.nextInt();
					addRecord(new Person(name, new Date(birthMonth, birthDay, birthYear), new Date(deathMonth, deathDay, deathYear)));
				} else {
					addRecord(new Person(name, new Date(birthMonth, birthDay, birthYear), null));
				}
			} else if (command.equals("delete")) {
				System.out.print("Enter the name of the person you would like to remove: \n> ");
				String name = scan.nextLine();
				deleteRecord(name);
			} else if (command.equals("view")) {
				System.out.print("Enter the name of the person you would like to view: \n> ");
				String name = scan.nextLine();
				displayRecord(name);
			} else if (command.equals("sort")) {
				System.out.print("What is the youngest age you'd like to view? \n> ");
				int young = scan.nextInt();
				scan.nextLine(); // Purge the newline
				System.out.print("What is the oldest age you'd like to view? \n> ");
				int old = scan.nextInt();
				scan.nextLine(); // Purge the newline
				Person[] array = retrievePeopleAged(young, old);
				for (Person p : array) {
					System.out.println(p);
				}
			} else if (command.equals("quit")) {
				System.out.println("Thank you!");
				System.exit(0);
			} else if (command.equals("list")) {
				listCommands();
			} else {
				System.out.println("Not a valid command... Try one of the following: ");
				listCommands();
			}
		}
	}
	
	public static void deleteRecord(String name) {
		if (people == null) {
			System.out.println("There are no records to delete. Try 'load' or 'add'.");
			return;
		}
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getName().equals(name)) {
				people.remove(i);
				System.out.println("Success! "+name+ " deleted from out records.");
				return;
			}
		}
		System.out.println("No person named "+name+" in our records.");
	}
	
	public static void addRecord(Person p) {
		if (people == null) {
			people = new ArrayList<Person>();
		}
		people.add(p);
	}
	
	public static Person displayRecord(String name) {
		if (people == null) {
			System.out.println("There are no records to display. Try 'load' or 'add'.");
			return null;
		}
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getName().equals(name)) {
				System.out.println(people.get(i));
				return new Person(people.get(i));
			}
		}
		System.out.println("Could not find anyone by the name "+name+".");
		return null;
	}
	
	public static Person[] retrievePeopleAged(int youngest, int oldest) {
		ArrayList<Person> aged = new ArrayList<Person>();
		for (int i = 0; i < people.size(); i++) {
			int age = people.get(i).getBirthDate().getAge(today);
			if (age >= youngest && age <= oldest) {
				aged.add(new Person(people.get(i)));
			}
		}
		Person[] ret = new Person[aged.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = new Person(aged.get(i));
		}
		return ret;
	}
	
	private static void writeData() {
		if (people == null) {
			System.out.println("No data to save.");
		}
		if (outStream == null) {
			try {
				outStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
			} catch (IOException ioe) {
				System.out.println("Could not create ObjectOutputStream. Aborting.");
				System.exit(0);
			}
		}
		try {
			for (int i = 0; i < people.size(); i++) {
				outStream.writeObject(people.get(i));
			}
		} catch (IOException e) {
			System.out.println("Could not output for some reason. Aborting.");
			System.exit(0);
		}
	}
	
	private static void readData() {
		if (people == null) {
			people = new ArrayList<Person>();
		}
		if (inStream == null) {
			try {
				inStream = new ObjectInputStream(new FileInputStream(FILENAME));
			} catch (FileNotFoundException fnfe) {
				System.out.println("No file named "+FILENAME);
				System.out.println("Try using the 'save' command to create it.");
				return;
			} catch (IOException ioe) {
				System.out.println("Could not create ObjectInputStream. Aborting.");
				System.exit(0);
			}
		}
		try {
			while (true) {
				Object o = inStream.readObject();
				if (o != null) {
					people.add((Person)o);
				}
			}
		} catch (EOFException e) {
			System.out.println("No more to read");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void listCommands() {
		System.out.println("Type 'load' to load in records");
		System.out.println("Type 'save' to save records");
		System.out.println("Type 'add' to add a record");
		System.out.println("Type 'delete' to delete a record");
		System.out.println("Type 'view' to view a record");
		System.out.println("Type 'sort' to find people of a certain age");
		System.out.println("Type 'quit' to quit");
	}
	
	private static Date parseDate(String line) {
		String month = line.substring(0, line.indexOf(" "));
		int day = Integer.parseInt(line.substring(line.indexOf(" ")+1, line.indexOf(", ")));
		int year = Integer.parseInt(line.substring(line.indexOf(", ")+2));
		return new Date(month, day, year);
	}
	
}
