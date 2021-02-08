package rumyantseva.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

  @Test
  public void testPoint () {
    Point p1 = new Point();
    p1.x = 15;
    p1.y = 25;
    Point p2 = new Point();
    p2.x = 10;
    p2.y = 25;
    Assert.assertEquals(p1.distanceconstrmet(p2.x, p2.y), 5);
  }

  @Test
  public void testPoint1 () {
    Point p1 = new Point(15, 25);
    Point p2 = new Point(15,20);
    Assert.assertEquals(p1.distanceconstrmet(p2), 5);
  }

}
