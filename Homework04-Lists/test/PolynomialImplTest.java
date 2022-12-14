
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test PolynomialImpl is work well.
 * 
 * @author eddie
 *
 */
public class PolynomialImplTest {

  /**
   * Test PolynomialImpl constructor.
   */
  @Test
  public void testPolynomialImpl() {
    Polynomial p = new PolynomialImpl("5");
    assertEquals("5", p.toString());
    p = new PolynomialImpl("3x^1");
    assertEquals("3x^1", p.toString());
    p = new PolynomialImpl("4x^3 +3x^1 -5");
    assertEquals("4x^3 +3x^1 -5", p.toString());
    p = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals("-2x^5 -3x^4 +11x^1 -5", p.toString());
    p = new PolynomialImpl("59206416x^565 -362565x^1 -5");
    assertEquals("59206416x^565 -362565x^1 -5", p.toString());

    try {
      p = new PolynomialImpl("-3x^-4 -2x^5 -5 +11x^1");
      fail("Did not throw exception on power below than 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  /**
   * Test addterm method work well.
   */
  @Test
  public void testAddTerm() {
    Polynomial p = new PolynomialImpl();
    p.addTerm(5, 2);
    p.addTerm(3, 1);
    p.addTerm(6, 3);
    assertEquals("6x^3 +5x^2 +3x^1", p.toString());
    p.addTerm(-3, 4);
    p.addTerm(-2, 1);
    assertEquals("-3x^4 +6x^3 +5x^2 +1x^1", p.toString());
    p.addTerm(1, 0);
    assertEquals("-3x^4 +6x^3 +5x^2 +1x^1 +1", p.toString());
    p.addTerm(-3, 1);
    assertEquals("-3x^4 +6x^3 +5x^2 -2x^1 +1", p.toString());
    p.addTerm(-5, 6);
    assertEquals("-5x^6 -3x^4 +6x^3 +5x^2 -2x^1 +1", p.toString());
    p.addTerm(-5, 0);
    assertEquals("-5x^6 -3x^4 +6x^3 +5x^2 -2x^1 -4", p.toString());
    p.addTerm(-1059, 504);
    assertEquals("-1059x^504 -5x^6 -3x^4 +6x^3 +5x^2 -2x^1 -4", p.toString());
    p.addTerm(1000, 504);
    assertEquals("-59x^504 -5x^6 -3x^4 +6x^3 +5x^2 -2x^1 -4", p.toString());
    Polynomial c = new PolynomialImpl();
    c.addTerm(2, 1);
    assertEquals("2x^1", c.toString());
    c.addTerm(-2, 1);
    assertEquals("0", c.toString());

    try {
      p.addTerm(1, -2);
      fail("Did not throw exception on power below than 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      p.addTerm(0, -2);
      fail("Did not throw exception on power below than 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  /**
   * Test if removeTerm work.
   */
  @Test
  public void testRemoveTerm() {
    Polynomial p = new PolynomialImpl();
    p.addTerm(-5, 2);
    p.addTerm(3, 1);
    p.addTerm(6, 3);
    p.addTerm(7, 0);
    p.addTerm(-5, 6);
    p.addTerm(2, 9);
    p.removeTerm(2);
    assertEquals("2x^9 -5x^6 +6x^3 +3x^1 +7", p.toString());
    p.removeTerm(0);
    assertEquals("2x^9 -5x^6 +6x^3 +3x^1", p.toString());
    p.removeTerm(8);
    p.removeTerm(5);
    assertEquals("2x^9 -5x^6 +6x^3 +3x^1", p.toString());
    p.removeTerm(9);
    assertEquals("-5x^6 +6x^3 +3x^1", p.toString());
    p.addTerm(656, 501);
    p.removeTerm(501);
    assertEquals("-5x^6 +6x^3 +3x^1", p.toString());

  }

  /**
   * Test if getDegree work.
   */
  @Test
  public void testGetDegree() {
    Polynomial p = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals(5, p.getDegree());
    p.addTerm(5656416, 99);
    assertEquals(99, p.getDegree());
    Polynomial s = new PolynomialImpl("5");
    assertEquals(0, s.getDegree());
    s = new PolynomialImpl();
    assertEquals(0, s.getDegree());
  }

  /**
   * Test getCofficient work well.
   */
  @Test
  public void testGetCoefficient() {
    Polynomial p = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals(-2, p.getCoefficient(5));
    assertEquals(-3, p.getCoefficient(4));
    assertEquals(0, p.getCoefficient(3));
    assertEquals(11, p.getCoefficient(1));
    assertEquals(-5, p.getCoefficient(0));

  }

  /**
   * Test if evaluate work.
   */
  @Test
  public void testEvaluate() {
    Polynomial p = new PolynomialImpl("2x^2");
    assertEquals(8, p.evaluate(2), 0.09);
    p = new PolynomialImpl("5");
    assertEquals(5, p.evaluate(2), 0.09);
    p = new PolynomialImpl("2x^2 +11x^1");
    assertEquals(30, p.evaluate(2), 0.09);
    p = new PolynomialImpl("-99x^30 +1000x^50 +2");
    double expected = -99 * ((double) Math.pow(2, 30)) + 1000 * ((double) Math.pow(2, 50)) + 2;
    assertEquals(expected, p.evaluate(2), 0.09);
    p = new PolynomialImpl("-99x^30 +1000x^50 +2");
    assertEquals(2, p.evaluate(0), 0.09);

  }

  /**
   * Test add method work well.
   */
  @Test
  public void testAdd() {
    Polynomial p = new PolynomialImpl("2x^2");
    Polynomial o = new PolynomialImpl("3x^3");
    Polynomial c = p.add(o);
    assertEquals("3x^3 +2x^2", c.toString());
    o = new PolynomialImpl("2x^2");
    c = p.add(o);
    assertEquals(p, p);
    assertNotEquals(c, p.add(o));
    assertEquals("4x^2", c.toString());
    o = new PolynomialImpl("-2x^2");
    c = p.add(o);
    assertEquals("0", c.toString());
    p = new PolynomialImpl("-2x^5 -3x^4 +11x^1 -5");
    o = new PolynomialImpl("-3x^4 +6x^3 +5x^2 -2x^1 +1");
    c = p.add(o);
    assertEquals("-2x^5 -6x^4 +6x^3 +5x^2 +9x^1 -4", c.toString());
    p = new PolynomialImpl();
    o = new PolynomialImpl();
    c = p.add(o);
    assertEquals("0", c.toString());
    o = new PolynomialImpl("-2");
    c = p.add(o);
    assertEquals("-2", c.toString());
    p = new PolynomialImpl("6");
    o = new PolynomialImpl("9");
    c = p.add(o);
    assertEquals("15", c.toString());

  }

}
