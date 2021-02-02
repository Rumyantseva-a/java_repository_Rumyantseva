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



    Distance dd  = new Distance();
    dd.x1 = 4;
    dd.y1 = 8;
    dd.x2 = 5;
    dd.y2 = 12;
    System.out.println ("Расстояние между точками p1 и p2 = " + distancefunc(dd));


    Point p1 = new Point();
    Point p2 = new Point();
    p1.x = 4;
    p2.x = 8;
    p1.y = 5;
    p2.y = 12;
    System.out.println ("3.Расстояние между точками p1 и p2 = " + distance(p1, p2));

    System.out.println ("4.Расстояние между точками p1 и p2 = " + p1.distanceconstrmet1(p2));



    Point p3 = new Point();
    Point p4 = new Point();
    p3.x = 5;
    p4.x = 10;
    p3.y = 15;
    p4.y = 20;
    System.out.println ("4. Расстояние между точками p3 и p4 = " + p3.distanceconstrmet1(p4));




    Point p5 = new Point();
    p5.x = 30;
    p5.y = 50;
    x1 = 200;
    System.out.println ("4. Расстояние между точками p5 и произвольной точкой = " + p5.distanceconstrmet2(x1, y1));








    Pointdistanceconstr pp  = new Pointdistanceconstr(4,8,5,12);
    System.out.println ("Расстояние между точками p1 и p2 = " + distancefunc(pp));


    Pointdistanceconstrmet pdcm = new Pointdistanceconstrmet(4,8,5,12);
    System.out.println ("Расстояние между точками p1 и p2 = " + pdcm.distanceconstrmet());



  }

  public static double distancefunc (Distance dd) {
    return Math.sqrt((dd.x2 - dd.x1) * (dd.y2 - dd.y1));

  }

  public static double distancefunc (Pointdistanceconstr pp) {
    return Math.sqrt((pp.x2 - pp.x1) * (pp.y2 - pp.y1));

  }

  //2
  public static double distance (Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.y - p1.y));


  }


}