
public class RightTriangle implements Shape {
	
	private double height;
	private double width;
	
	public RightTriangle (double h, double w) {
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
		return 0.5 * this.height * this.width;
	}
	
}
