public class Point {

    public double x;
    public double y;

    public Point (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double secondX(){
        return x;
    }

    public double secondY(){
        return y;
    }

    public double distance(Point second){
        double d = Math.round(Math.sqrt(second.secondX() - x)*(second.secondX() - x)+((second.secondY() - y)*(secondY() - y)));
        return d;
    }

}