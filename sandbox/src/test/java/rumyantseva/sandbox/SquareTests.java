package rumyantseva.sandbox;

import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea () {
    Squareconstrmet s = new Squareconstrmet(5);
    assert s.areaconstrmet() == 25;
  }
}
