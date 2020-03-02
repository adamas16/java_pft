public class MyFirstProgram{
	public static void main(String[] args) {

		hello("men");
		hello("world");

		Point p1 = new Point(3.0, 5.0);
		Point p2 = new Point(7.0, 8.0);

		System.out.println("Расстояние между точкой p1 и p2 составляет" + " " + distance(p1, p2));
	}

	public static double distance(Point p1, Point p2) {
		double distance = Math.round(Math.sqrt((p2.x - p1.x)*(p2.x - p1.x)+(p2.y - p1.y)*(p2.y - p1.y)));
		return distance;
	}

	public static void hello(String somebody){
		System.out.println("Hello, " + somebody + "!");
	}
}