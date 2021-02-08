package rumyantseva.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello" + "world!");



        System.out.println(2 + 2);
        System.out.println(2 * 2);
        System.out.println(4 / 2);
        System.out.println(6 - 2);

        System.out.println(2 + "2");
        System.out.println(12.4 / 4);

        System.out.println((2 + 2) * 2);
        System.out.println(2 + 2 * 2);

        System.out.println("2 + 2 = " + (2 + 2));

        System.out.println("Площадь квадрата со стороной " + 5 + " = " + (5 * 5));

        int l = 8;
        int s = l * l;
        System.out.println("Площадь квадрата со стороной " + l + " = " + s);

        double d = 8.5;
        double e = d * d;
        System.out.println("Площадь квадрата со стороной " + d + " = " + e);

        String  somebody = "world";
        System.out.println("Hello, " + somebody + "!");

        hello("world");
        hello("user");
        hello("Nastya");

        double qwe = 6;
        System.out.println("Площадь квадрата со стороной " + qwe + " = " + area(qwe));


        Square sq = new Square(5);
        System.out.println("Площадь квадрата со стороной " + sq.k + " = " + areafunc(sq));

        Square sqc = new Square(4);
        System.out.println("Площадь квадрата со стороной " + sqc.k + " = " + areafuncconst(sqc));

        Square sqcm = new Square(43);
        System.out.println("Площадь квадрата со стороной " + sqcm.k + " = " + sqcm.areaconstrmet());

        double q = 4;
        double w = 10;
        System.out.println("Площадь прямоугольника со сторонами " + q + " и " + w +  " = " + area(q, w));

        Rectangle rq  = new Rectangle(5, 20);
        System.out.println("Площадь прямоугольника со сторонами " + rq.dl + " и " + rq.wi + " = " + areafunc(rq));

        Rectangle rqc = new Rectangle(35, 48);
        System.out.println("Площадь прямоугольника со сторонами " + rqc.dl + " и " + rqc.wi +  " = " + areafuncconst(rqc));

        Rectangle rqcm = new Rectangle(43, 12);
        System.out.println("Площадь прямоугольника со сторонами " + rqcm.dl + " и " + rqcm.wi + " = " + rqcm.areaconstrmetrec());
    }



    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");

    }

    public static double area (double rty) {
        return rty * rty;


    }

    public static double area (double q, double w) {
        return q * w;


    }

    public static double areafunc (Square sq) {
        return sq.k * sq.k;

    }

    public static double areafunc (Rectangle rq) {
        return rq.dl * rq.wi;

    }

    public static double areafuncconst (Square sqc) {
        return sqc.k * sqc.k;

    }

    public static double areafuncconst (Rectangle rqc) {
        return rqc.wi * rqc.dl;

    }


}