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


}