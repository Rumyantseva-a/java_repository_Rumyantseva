package rumyantseva.sandbox;

public class Point {

  public double x;
  public double y;


  public double distanceconstrmet1(Point p) {
    return Math.sqrt((p.x - this.x) * (p.y - this.y));

  }

  public double distanceconstrmet2(double a, double b) {
//    return Math.sqrt((a - this.x) * (b - this.y));
    return Math.sqrt( Math.abs(a - this.x) * Math.abs(b - this.y));

  }
}