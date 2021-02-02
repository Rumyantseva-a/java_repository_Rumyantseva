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

        double q = 4;
        double w = 10;
        System.out.println("Площадь прямоугольника со сторонами " + q + " и " + w +  " = " + area(q, w));
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


}