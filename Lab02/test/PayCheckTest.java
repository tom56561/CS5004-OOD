
import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.junit.Test;

/**
 * A JUnit test class for the PayCheck class.
 */
public class PayCheckTest {

  /**
   * Tests if ToString properly returns the PayCheck‘s totalpay.
   */
  @Test
  public void testToString() {
    double payRate = 0;
    double hoursWorked;

    PayCheck emily;
    String expected;

    Random random = new Random(12345);
    payRate = random.nextDouble() * 100;
    emily = new PayCheck("Emily", payRate, 0);
    assertEquals("$0.00", emily.toString());

    for (int test = 0; test < 5000; test++) {
      payRate = random.nextDouble() * 100;
      hoursWorked = random.nextDouble() * 40;
      emily = new PayCheck("Emily", payRate, hoursWorked);
      double totalPay = payRate * Math.min(hoursWorked, 40)
          + payRate * Math.max(0, hoursWorked - 40) * (1.5 * payRate);
      expected = String.format("$%.2f", totalPay);
      assertEquals(expected, emily.toString());

    }
  }

  /**
   * Tests if getWeeklyCheck properly returns the employee week's hours.
   */
  @Test
  public void testGetTotalPay() {
    double payRate = 0;
    double hoursWorked;

    PayCheck emily;
    double expected;

    Random random = new Random(12345);
    payRate = random.nextDouble() * 100;
    emily = new PayCheck("Emily", payRate, 0);
    assertEquals(0.00, emily.getTotalPay(), 0.01);

    for (int test = 0; test < 5000; test++) {
      payRate = random.nextDouble() * 100;
      hoursWorked = random.nextDouble() * 40;
      emily = new PayCheck("Emily", payRate, hoursWorked);
      expected = payRate * Math.min(hoursWorked, 40)
          + payRate * Math.max(0, hoursWorked - 40) * (1.5 * payRate);
      assertEquals(expected, emily.getTotalPay(), 0.01);

    }

  }

}
