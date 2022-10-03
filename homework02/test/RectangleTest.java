import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

/**
 * A JUnit test class for the Rectangle class.
 */
public class RectangleTest {

  /**
   * Tests Rectangle construct properly work.
   */
  @Test
  public void testRectangle() {
    Rectangle firstRectangle = new Rectangle(2, 3, 4, 5);
    assertEquals("x:2, y:3, w:4, h:5", firstRectangle.toString());

    Rectangle secondRectangle = new Rectangle(-2, -3, 4, 5);
    assertEquals("x:-2, y:-3, w:4, h:5", secondRectangle.toString());
  }

  /**
   * Tests if input negative width or height Rectangle construct will throw
   * IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRectangle() {
    Rectangle firstRectangle = new Rectangle(2, 3, -4, 5);
  }

  /**
   * Tests if ToString properly returns the Rectangle's x, y, w, and h.
   */
  @Test
  public void testToString() {

    Rectangle firstRectangle;
    String expected;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      int x = random.nextInt();
      int y = random.nextInt();
      int w = Math.abs(random.nextInt());
      int h = Math.abs(random.nextInt());
      firstRectangle = new Rectangle(x, y, w, h);
      expected = String.format("x:%d, y:%d, w:%d, h:%d", x, y, w, h);
      assertEquals(expected, firstRectangle.toString());
    }
  }

}
