import java.util.ArrayList;

public class MyMathClass <T extends Number> {
	
	public double standardDeviation (ArrayList<T> list) {
		double xBar = average(list);
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += (list.get(i).doubleValue() - xBar)*(list.get(i).doubleValue() - xBar);
		}
		return Math.sqrt(sum/list.size());
	}
	
	public double average (ArrayList<T> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).doubleValue();
		}
		return sum / list.size();
	}
	
}
