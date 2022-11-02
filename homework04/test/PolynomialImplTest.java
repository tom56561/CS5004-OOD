import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialImplTest {

  @Test
  public void testPolynomialImpl() {
    PolynomialImpl p = new PolynomialImpl("5");
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
    try {
      p = new PolynomialImpl("-3x^4 0x^5 -5 +11x^1");
      fail("Did not throw exception on coef equal 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testAddTerm() {
    PolynomialImpl p = new PolynomialImpl();
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

    try {
      p.addTerm(0, 1);
      fail("Did not throw exception on coef equal 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      p.addTerm(1, -2);
      fail("Did not throw exception on power below than 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      p.addTerm(0, -2);
      fail("Did not throw exception on power below than 0 and coef equal 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testRemoveTerm() {
    PolynomialImpl p = new PolynomialImpl();
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

    try {
      p.removeTerm(-2);
      fail("Did not throw exception on power below than 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }

  @Test
  public void testGetDegree() {
    PolynomialImpl p = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals(5, p.getDegree());
    p.addTerm(5656416, 99);
    assertEquals(99, p.getDegree());
    PolynomialImpl s = new PolynomialImpl("5");
    assertEquals(0, s.getDegree());
    s = new PolynomialImpl();
    assertEquals(0, s.getDegree());
  }

  @Test
  public void testGetCoefficient() {
    PolynomialImpl p = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals(-2, p.getCoefficient(5));
    assertEquals(-3, p.getCoefficient(4));
    assertEquals(0, p.getCoefficient(3));
    assertEquals(11, p.getCoefficient(1));
    assertEquals(-5, p.getCoefficient(0));

    try {
      p.getCoefficient(-2);
      fail("Did not throw exception on power below than 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testEvaluate() {
    PolynomialImpl p = new PolynomialImpl("2x^2");
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

  @Test
  public void testAdd() {
    PolynomialImpl p = new PolynomialImpl("2x^2");
    PolynomialImpl o = new PolynomialImpl("3x^3");
    assertEquals("3x^3 +2x^2", p.add(o).toString());
    o = new PolynomialImpl("2x^2");
    assertEquals("4x^2", p.add(o).toString());
    o = new PolynomialImpl("-2x^2");
    assertEquals("0", p.add(o).toString());
    p = new PolynomialImpl("-2x^5 -3x^4 +11x^1 -5");
    o = new PolynomialImpl("-3x^4 +6x^3 +5x^2 -2x^1 +1");
    assertEquals("-2x^5 -6x^4 +6x^3 +5x^2 +9x^1 -4", p.add(o).toString());
    p = new PolynomialImpl();
    o = new PolynomialImpl();
    assertEquals("0", p.add(o).toString());
    o = new PolynomialImpl("-2");
    assertEquals("-2", p.add(o).toString());
    p = new PolynomialImpl("6");
    o = new PolynomialImpl("9");
    assertEquals("15", p.add(o).toString());

  }

}
