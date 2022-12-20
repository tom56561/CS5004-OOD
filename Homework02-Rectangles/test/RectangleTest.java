import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
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
   * Tests if input negative width or height, Rectangle construct will throw
   * IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRectangle() {
    Rectangle firstRectangle = new Rectangle(2, 3, -4, 5);
  }

  /**
   * Tests if overlap properly returns the boolean.
   */
  @Test
  public void testOverlap() {

    Rectangle first;
    Rectangle other;
    first = new Rectangle(0, 0, 5, 5);
    other = new Rectangle(-3, 0, 2, 3);
    assertEquals(false, first.overlap(other));
    other = new Rectangle(-3, 0, 4, 3);
    assertEquals(true, first.overlap(other));
    other = new Rectangle(-3, 0, 3, 3);
    assertEquals(false, first.overlap(other));

    boolean expected;
    Random random = new Random(12345);

    for (int test = 0; test < 1000; test++) {
      int x = random.nextInt();
      int y = random.nextInt();
      int w = Math.abs(random.nextInt());
      int h = Math.abs(random.nextInt());
      int ax = random.nextInt();
      int ay = random.nextInt();
      int aw = Math.abs(random.nextInt());
      int ah = Math.abs(random.nextInt());
      first = new Rectangle(x, y, w, h);
      other = new Rectangle(ax, ay, aw, ah);
      expected = x < ax + aw && ax < x + w && y < ay + ah && ay < y + h;
      assertEquals(expected, first.overlap(other));
    }
  }

  /**
   * Tests if intersect properly returns Rectangle object.
   */
  @Test
  public void testIntersect() {

    Rectangle first;
    Rectangle other;
    first = new Rectangle(0, 0, 2, 5);
    other = new Rectangle(0, -2, 4, 3);
    assertEquals("x:0, y:0, w:2, h:1", first.intersect(other).toString());

    String expected;
    Random random = new Random(12345);

    for (int test = 0; test < 1000; test++) {
      int x = random.nextInt();
      int y = random.nextInt();
      int w = Math.abs(random.nextInt());
      int h = Math.abs(random.nextInt());
      int ax = random.nextInt();
      int ay = random.nextInt();
      int aw = Math.abs(random.nextInt());
      int ah = Math.abs(random.nextInt());
      first = new Rectangle(x, y, w, h);
      other = new Rectangle(ax, ay, aw, ah);
      int xL = Math.max(x, ax);
      int xR = Math.min(x + w, ax + aw);
      int yB = Math.max(y, ay);
      int yT = Math.min(y + h, ay + ah);
      expected = String.format("x:%d, y:%d, w:%d, h:%d", xL, yB, xR - xL, yT - yB);
      try {
        assertEquals(expected, first.intersect(other).toString());
      } catch (NoSuchElementException e) {
        System.out.print("No intersection");
      }
    }
  }

  /**
   * Tests if union properly returns Rectangle object.
   */
  @Test
  public void testUnion() {

    Rectangle first;
    Rectangle other;
    first = new Rectangle(0, 0, 10, 5);
    other = new Rectangle(5, 2, 5, 5);
    assertEquals("x:0, y:0, w:10, h:7", first.union(other).toString());

    String expected;
    Random random = new Random(12345);

    for (int test = 0; test < 1000; test++) {
      int x = random.nextInt(1000);
      int y = random.nextInt(1000);
      int w = random.nextInt(1000) + 1;
      int h = random.nextInt(1000) + 1;
      int ax = random.nextInt(1000);
      int ay = random.nextInt(1000);
      int aw = random.nextInt(1000) + 1;
      int ah = random.nextInt(1000) + 1;

      first = new Rectangle(x, y, w, h);
      other = new Rectangle(ax, ay, aw, ah);
      int xL = Math.min(x, ax);
      int xR = Math.max(x + w, ax + aw);
      int yB = Math.min(y, ay);
      int yT = Math.max(y + h, ay + ah);
      expected = String.format("x:%d, y:%d, w:%d, h:%d", xL, yB, xR - xL, yT - yB);
      assertEquals(expected, first.union(other).toString());
    }
  }

  /**
   * Tests if ToString properly returns the Rectangle's x, y, w, and h.
   */
  @Test
  public void testToString() {

    Rectangle firstRectangle;
    String expected;
    Random random = new Random(12345);

    for (int test = 0; test < 1000; test++) {
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
