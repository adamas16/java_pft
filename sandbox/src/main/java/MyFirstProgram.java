public class MyFirstProgram{
<<<<<<< HEAD
	public static double x1, y1, x2, y2;

	public static void main(String[] args)
	{
		Point p1 = new Point(4,6);
		Point p2 = new Point(7,10);
		System.out.println("Расстояние между двумя точками  p1(" + p1.a + "," + p1.b + ") и p2(" + p2.a + "," + p2.b + ") = " + distance1(p1,p2));

		System.out.println("Расстояние между двумя точками  p1(" + p1.a + "," + p1.b + ") и p2(" + p2.a + "," + p2.b + ") = " + p1.distance(p1,p2));
	}

	public static double distance1(Point p1, Point p2)
	{
		return Math.sqrt((p1.a-p2.a)*(p1.a-p2.a) + (p1.b-p2.b)*(p1.b-p2.b));
	}


=======
	public static void main(String[] args) {
		System.out.println("Hello, world!");	
	}
>>>>>>> parent of d9ae437... Задание 2
}