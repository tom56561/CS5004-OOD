
import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

/**
 * A JUnit test class for the Employee class.
 */
public class EmployeeTest {

  /**
   * Tests if getName properly returns the employee's name.
   */
  @Test
  public void testGetName() {

    String expected = "Emily";
    Employee emily = new Employee(expected, 10.75);
    String actual = emily.getName();
    assertEquals(expected, actual);

    expected = "john";
    Employee john = new Employee(expected, 10.75);
    actual = john.getName();
    assertEquals(expected, actual);

    expected = "eddie";
    Employee eddie = new Employee(expected, 10.75);
    actual = eddie.getName();
    assertEquals(expected, actual);

  }

  /**
   * Tests if getPayRate properly returns the employee's payRate.
   */
  @Test
  public void testGetPayRate() {
    double expected = 10.75;
    Employee emily;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      expected = random.nextDouble() * 200;

      emily = new Employee("Emily", expected);

      double actual = emily.getPayRate();

      assertEquals(expected, actual, 0.009);
    }
  }

  /**
   * Tests if GetHoursWorked properly returns the employee's HoursWorked.
   */
  @Test
  public void testGetHoursWorked() {

    double expected;
    Employee emily;
    Random random = new Random(12345);

    emily = new Employee("Emily", 10.75);
    assertEquals(0, emily.getHoursWorked(), 0.009);

  }

  /**
   * Tests if AddHoursWorked properly returns the employee's HoursWorked after
   * adding.
   */
  @Test
  public void testAddHoursWorked() {
    double payRate = 0;
    double newHours;
    Employee emily;
    double expected;
    double actual;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      payRate = random.nextDouble() * 200;
      emily = new Employee("Emily", payRate);
      assertEquals(0, emily.getHoursWorked(), 0.009);

      newHours = random.nextDouble() * 8;
      emily.addHoursWorked(newHours);
      actual = emily.getHoursWorked();
      assertEquals(newHours, actual, 0.009);

      expected = newHours;
      newHours = random.nextDouble() * 8;
      expected += newHours;
      emily.addHoursWorked(newHours);
      actual = emily.getHoursWorked();
      assertEquals(expected, actual, 0.009);

    }

  }

  /**
   * Tests if ResetHoursWorked properly returns the employee's HoursWorked after
   * reseting.
   */
  @Test
  public void testResetHoursWorked() {
    Employee emily;
    double expected;
    double actual;

    emily = new Employee("Emily", 10.75);
    emily.resetHoursWorked();
    assertEquals(0, emily.getHoursWorked(), 0.009);

  }

  /**
   * Tests if ToString properly returns the employee's name.
   */
  @Test
  public void testToString() {
    String name = "Min Johnson";
    Employee employee1 = new Employee(name, 10.75);

    Random random = new Random(12345);
    Employee emily;
    for (int test = 0; test < 5000; test++) {
      int a = random.nextInt();
      name = a + "";
      emily = new Employee(name, 10.75);
      assertEquals(name, emily.toString());
    }
  }

  /**
   * Tests if getWeeklyCheck properly returns the employee week's hours.
   */
  @Test
  public void testGetWeeklyCheck() {
    double payRate = 0;
    double newHours;
    Employee emily;
    String expected;
    double actual;

    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      payRate = random.nextDouble() * 100;
      emily = new Employee("Emily", payRate);

      assertEquals("$0.00", emily.getWeeklyCheck().toString());

      newHours = random.nextDouble() * 8;

      emily.addHoursWorked(newHours);

      expected = String.format("$%.2f", emily.getHoursWorked() * emily.getPayRate());
      assertEquals(expected, emily.getWeeklyCheck().toString());

    }

  }

}