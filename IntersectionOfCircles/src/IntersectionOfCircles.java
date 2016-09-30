import java.util.Scanner;

public class IntersectionOfCircles {

	public static void main(String[] args) {
		Scanner cs = new Scanner(System.in);
		Circle cir1 = readCircle(cs);
		Circle cir2 = readCircle(cs);
		if (IsCirclesIntersect(cir1, cir2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	private static boolean IsCirclesIntersect(Circle cir1, Circle cir2) {

		return ((calculateDistance(cir1.center, cir2.center)) <= cir1.radius + cir2.radius);
	}
	private static double calculateDistance(Point p1, Point p2) {
		double side1 = p1.x - p2.x;
		double side2 = p1.y - p2.y;
		return Math.sqrt(side1 * side1 + side2 * side2);

	}
	public static Circle readCircle(Scanner cs) {
		
		String[] dimensions = new String[3];
				dimensions = cs.nextLine().split(" ");
		double rad = Double.parseDouble(dimensions[2]);
		double x = Double.parseDouble(dimensions[0]);
		double y = Double.parseDouble(dimensions[1]);

		return new Circle(new Point(x, y), rad);
		
	}
}
class Point {
	double x;
	double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;

	}

}
class Circle {
	Point center;
	double radius;

	public Circle(Point center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public double getRaduius() {
		return radius;
	}

	public void setRaduius(double raduius) {
		this.radius = raduius;
	}
}