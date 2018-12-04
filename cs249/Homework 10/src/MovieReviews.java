import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

public class MovieReviews {
	
	public static void main(String[] args) {
		
		HashMap<String, Integer[]> reviews = new HashMap<String, Integer[]>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src\\reviews.txt"));
			int num = Integer.parseInt(reader.readLine());
			for (int i = 0; i < num; i++) {
				String title = reader.readLine();
				int rating = Integer.parseInt(reader.readLine());
				if (!reviews.containsKey(title)) {
					Integer[] a = new Integer[] {1, rating};
					reviews.put(title, a);
				} else {
					Integer[] a = reviews.get(title);
					a[0]++;
					a[1] += rating;
					reviews.replace(title, a);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Iterator it = reviews.keySet().iterator();
		while (it.hasNext()) {
			String key = (String)it.next();
			String review = key+": ";
			review += reviews.get(key)[0] + " reviews, ";
			review += "average of " + ((double)reviews.get(key)[1]/reviews.get(key)[0]) + " / 5";
			System.out.println(review);
			it.remove();
		}
	}
	
}
