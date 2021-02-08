package rumyantseva.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Squaretests1 {

  @Test
  public void testArea () {
    Square s = new Square(5);
    Assert.assertEquals(s.areaconstrmet(),25);
  }
}
