package rumyantseva.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  //public static void main(String[] args) {
  //  String[] langs = {"java", "C#", "Python", "PHP"};
  //  for (int i = 0; i < langs.length; i++) {
  //    System.out.println("Я хочу выучить " + langs[i]);
  //  }
  //}

  public static void main(String[] args) {
    String[] langs = {"java", "C#", "Python", "PHP"};
    List<String> languages = Arrays.asList("Java", "C#", "Python");

    //for (String l : languages) {
    //  System.out.println("Я хочу выучить " + l);
    //}

    for (String l : languages){
      System.out.println("Я хочу выучить " + l);
    }
  }
}
