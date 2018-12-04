
public class Circle implements Shape {
	
	private double radius;
	
	public Circle (double r) {
		this.radius = r;
	}
	
	public void setRadius (double r) {
		this.radius = r;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double area() {
		return Math.PI * this.radius * this.radius;
	}
	
}
