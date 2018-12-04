
public class ShapeDemo {
	
	public static void main(String[] args) {
		Shape[] shapes = new Shape[] {
				new Circle(4),
				new Rectangle(4, 3),
				new RightTriangle(10, 2),
				new Circle(1),
				new Rectangle(3, 5),
				new RightTriangle(5.5, 3.5)
		};
		for (Shape s : shapes) {
			showArea(s);
		}
	}
	
	public static void showArea(Shape s) {
		double area = s.area();
		System.out.println("The area of the " + s.getClass() + " is " + area);
	}
	
}
