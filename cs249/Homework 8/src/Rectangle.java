
public class Rectangle implements Shape {
	
	private double height;
	private double width;
	
	public Rectangle (double h, double w) {
		this.height = h;
		this.width = w;
	}
	
	public void setWidth (double w) {
		this.width = w;
	}
	
	public void setHeight (double h) {
		this.height = h;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double area() {
		return this.height * this.width;
	}
	
}
