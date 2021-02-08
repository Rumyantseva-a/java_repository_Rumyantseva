package rumyantseva.sandbox;

public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point() {
  }


  public double distanceconstrmet(Point p) {
    return Math.sqrt((p.x - this.x)*(p.x - this.x) + (p.y - this.y)*(p.y - this.y));

  }

  public double distanceconstrmet(double a, double b) {

    return Math.sqrt((a - this.x)*(a - this.x) + (b - this.y)*(b - this.y));

  }

}