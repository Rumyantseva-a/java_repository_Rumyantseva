package rumyantseva.sandbox;

public class MySecondProgram {

  public static void main(String[] args) {

    double x1 = 4;
    double y1 = 8;
    System.out.println("Координаты точки p1 (" + x1 + " ; " + y1 +  ")");

    double x2 = 5;
    double y2 = 12;
    System.out.println("Координаты точки p2 (" + x2 + " ; " + y2 +  ")");


    System.out.println ("Расстояние между точками p1 и p2 = " + Math.sqrt((x2 - x1) * (y2 - y1)));






    Point p1 = new Point(15, 25);
    Point p2 = new Point(10, 25);
    p1.x = 15;
    p2.x = 10;
    p1.y = 25;
    p2.y = 25;
    System.out.println ("3.Расстояние между точками p1 и p2 = " + distance(p1, p2));

    System.out.println ("4.Расстояние между точками p1 и p2 = " + p1.distanceconstrmet(p2));



    Point p3 = new Point(5, 15);
    Point p4 = new Point(10, 20);
    p3.x = 5;
    p4.x = 10;
    p3.y = 15;
    p4.y = 20;
    System.out.println ("4. Расстояние между точками p3 и p4 = " + p3.distanceconstrmet(p4));




    Point p5 = new Point(30, 50);
    p5.x = 30;
    p5.y = 50;
    x1 = 200;
    System.out.println ("4. Расстояние между точками p5 и произвольной точкой = " + p5.distanceconstrmet(x1, y1));



    Point pp1  = new Point(4,8);
    Point pp2  = new Point(10,17);
    System.out.println ("Расстояние между точками p1 и p2 = " + distance(pp1, pp2));


    Point pdcm = new Point(4,8);
    System.out.println ("Расстояние между точками p1 и p2 = " + pdcm.distanceconstrmet(5, 12));



  }


  //2
  public static double distance (Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) +  (p2.y - p1.y)* (p2.y - p1.y));


  }


}