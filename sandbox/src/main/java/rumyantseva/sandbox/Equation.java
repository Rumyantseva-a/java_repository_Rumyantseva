package rumyantseva.sandbox;

public class Equation {

  private double a;
  private double b;
  private double c;

  private int n;

  public Equation(double a, double b, double c) {


    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;

    //if (a == 0)
    //  System.out.println("Это вырожденное уравнение");
    //фигурные скобки можно убрать, но нежелательно по причине
    // высокого риска ошибок по невнимательности;


    //неполная конструкция - отсутствует else, используется в некоторых случаях;
    //if (a == 0)
    //  System.out.println("Это вырожденное уравнение");


//свернутая форма конструкции if - else -
// допускается убрать фигурны скобки после else перед if при наличии еще одного условия else;
    //if (d > 0) {
    //  n = 2;
    //} else if (d == 0) {
    //  n = 1;
    // } else {
    //  n = 0;
    //   }

    //если условия взаимоисключающие, допустимо оформлять так:
    //if (d > 0) {
    //n = 2;
    //}

    //if (d == 0) {
    //n = 1;
    //}

    //if (d < 0) {
    //n = 0;
    //}
    //но лучше использовать конструкцию с else,
    // чтобы при совпадении с первым условием остальные два сравнения с 2 и 3 условиями не происходили;


    if (a != 0) {
      if (d > 0) {
        n = 2;
      } else if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }

    }

    else if (b != 0) {
      n = 1;
    }

    else if (c != 0) {
      n = 0;
    }

    else {
      n = -1;
    }





  }


  public int rootNumber() {
    return n;
  }
}
