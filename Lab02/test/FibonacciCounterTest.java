
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A JUnit test class for the FibonacciCounter class.
 */
public class FibonacciCounterTest {

  /**
   * Tests if getFibonacciNumber properly returns the correct FibonacciNumber.
   */
  @Test
  public void testGetFibonacciNumber() {
    FibonacciCounter fib;
    assertEquals(0, new FibonacciCounter(0).getFibonacciNumber());
    assertEquals(1, new FibonacciCounter(1).getFibonacciNumber());

    int fibValue = 1;
    int prevFibValue = 0;
    for (int test = 2; test < 46; test++) {
      fib = new FibonacciCounter(test);

      int temp = fibValue;
      fibValue = fibValue + prevFibValue;
      prevFibValue = temp;

      assertEquals("Fail for a counter of " + test, fibValue, fib.getFibonacciNumber());
    }
  }

  /**
   * Tests if incrementedBy1 properly returns the FibonacciNumber with its count
   * incremented by 1.
   */
  @Test
  public void testIncrementedBy1() {
    FibonacciCounter fib;
    assertEquals(1, new FibonacciCounter(0).incrementedBy1().getFibonacciNumber());
    assertEquals(1, new FibonacciCounter(1).incrementedBy1().getFibonacciNumber());

    int fibValue = 1;
    int prevFibValue = 0;
    for (int test = 2; test < 47; test++) {
      fib = new FibonacciCounter(test - 1);

      int temp = fibValue;
      fibValue = fibValue + prevFibValue;
      prevFibValue = temp;

      assertEquals("Fail for a counter of " + test, fibValue,
          fib.incrementedBy1().getFibonacciNumber());
    }
  }

  /**
   * Tests if decrementedBy1 properly returns the FibonacciNumber with its count
   * decremented by 1.
   */
  @Test
  public void testDecrementedBy1() {
    FibonacciCounter fib;
    assertEquals(0, new FibonacciCounter(0).decrementedBy1().getFibonacciNumber());
    assertEquals(0, new FibonacciCounter(1).decrementedBy1().getFibonacciNumber());
    assertEquals(1, new FibonacciCounter(2).decrementedBy1().getFibonacciNumber());

    int fibValue = 1;
    int prevFibValue = 0;
    for (int test = 2; test < 47; test++) {
      fib = new FibonacciCounter(test + 1);

      int temp = fibValue;
      fibValue = fibValue + prevFibValue;
      prevFibValue = temp;

      assertEquals("Fail for a counter of " + test, fibValue,
          fib.decrementedBy1().getFibonacciNumber());
    }
  }

  /**
   * Tests if getCount properly returns the Fibonacci count.
   */
  @Test
  public void testGetCount() {
    FibonacciCounter fib;
    for (int test = 0; test < 100; test++) {
      fib = new FibonacciCounter(test);

      assertEquals(test, fib.getCount());
    }
  }

  /**
   * Tests if getCountAndFib properly returns the count and Fibonacci number.
   */
  @Test
  public void testGetCountAndFib() {
    FibonacciCounter fib;
    String expected;
    assertEquals("(count:0, fib:0)", new FibonacciCounter(0).getCountAndFib());
    assertEquals("(count:1, fib:1)", new FibonacciCounter(1).getCountAndFib());

    int fibValue = 1;
    int prevFibValue = 0;
    for (int test = 2; test < 46; test++) {
      fib = new FibonacciCounter(test);

      int temp = fibValue;
      fibValue = fibValue + prevFibValue;
      prevFibValue = temp;

      expected = String.format("(count:%d, fib:%d)", test, fibValue);
      assertEquals("Fail for a counter of " + test, expected, fib.getCountAndFib());
    }
  }

}
