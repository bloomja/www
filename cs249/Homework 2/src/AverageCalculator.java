import java.text.DecimalFormat;
import java.util.Scanner;

public class AverageCalculator {
	
	static String[] exercises = new String[4];
	static int[] scores = new int[4];
	static int[] max = new int[4];
	static DecimalFormat percent = new DecimalFormat("0.00%");
	
	/*
	 *  All inputs are received in the receiveInput method. Data is stored in arrays,
	 *  one for each category of data inputted. The last item in the array is the sum
	 *  of the previous ones, used for totalling. After this, we call the printTable
	 *  method which does all the work. It composes a String object that contains all
	 *  the data for each row and subsequently prints that row's data. Lastly, we 
	 *  calculate the average with a simple division, and call the DecimalFormat's 
	 *  format method, giving it the proper appearance as a percentage. It outputs the
	 *  last line and the program terminates.
	 */
	
	public static void main(String[] args) {
		receiveInput();
		printTable();
	}
	
	public static void receiveInput() {
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			System.out.println("Name of exercise " + i + ": ");
			exercises[i-1] = scan.nextLine();
			System.out.println("Score received for exercise "+ i + ": ");
			scores[i-1] = Integer.parseInt(scan.nextLine());
			System.out.println("Total points possible for exercise " + i + ": ");
			max[i-1] = Integer.parseInt(scan.nextLine());
		}
		exercises[3] = "Total";
		scores[3] = scores[0] + scores[1] + scores[2];
		max[3] = max[0] + max[1] + max[2];
		scan.close();
	}
	
	public static void printTable() {
		String out = "Exercise";
		for (int i = out.length(); i < 20; i++) out += " ";
		out += "Score";
		for (int i = out.length(); i < 30; i++) out += " ";
		out += "Total Possible";
		System.out.println(out);
		for (int i = 0; i < 4; i++) {
			out = exercises[i];
			for (int j = out.length(); j < 20; j++) out += " ";
			out += scores[i];
			for (int j = out.length(); j < 30; j++) out += " ";
			out += max[i];
			System.out.println(out);
		}
		System.out.println("Your total is "+scores[3]+" out of "+max[3]+", or "+percent.format(((double)scores[3])/max[3]));
	}
	
}
