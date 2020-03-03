public class MyFirstProgram{

	public static void main(String[] args){
		Point p1 = new Point(4,6);
		Point p2 = new Point(7,10);
		System.out.println("Расстояние между двумя точками p1(" + p1.x + "," + p1.x + ") и p2(" + p2.x + "," + p2.x + ") = " + distance(p1,p2));
		System.out.println("Расстояние между двумя точками p1(" + p1.x + "," + p1.y + ") и p2(" + p2.x + "," + p2.y + ") = " + p1.distance(p2));
	}

	public static double distance(Point p1, Point p2)
	{
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
	}

}