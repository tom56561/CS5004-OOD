import org.junit.Before;
import org.junit.Test;

//import cs5004.temperature.CelsiusTemperature;
//import cs5004.temperature.FahrenheitTemperature;
//import cs5004.temperature.Temperature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;

/**
 * Tests for Temperature, both Celsius and Fahrenheit representations.
 */
public class TemperatureTest {

  private Temperature cTemp;
  private Temperature fTemp;

  @Before
  public void init() {
    cTemp = new CelsiusTemperature(100);
    fTemp = new FahrenheitTemperature(100, true);
  }

  /**
   * Tests if temperature is below absolute 0, will throw
   * IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testForInvalidFTemp() {
    new FahrenheitTemperature(-1000);
  }

  /**
   * Tests many IllegalArgumentException situation.
   */
  @Test
  public void testManyInvalidFTemp() {
    Random random = new Random(98776);
    double inTemp;
    for (int test = 0; test < 5000; test++) {
      inTemp = random.nextDouble() * 100;

      try {
        new CelsiusTemperature(Temperature.ABS_ZERO_C - inTemp);
        fail("Did not throw exception on temperature below absolute 0");
      } catch (IllegalArgumentException e) {
        // do nothing
      }
      try {
        new FahrenheitTemperature(Temperature.ABS_ZERO_C - inTemp, true);
        fail("Did not throw exception on temperature below absolute 0");
      } catch (IllegalArgumentException e) {
        // do nothing
      }
    }
  }

  /**
   * Tests inCelsius, inFahrenheit, and inKelvin method work correctly when
   * Celsius is 100.
   */
  @Test
  public void testObservers() {
    assertEquals(100, cTemp.inCelsius(), 0.001);
    assertEquals(212, cTemp.inFahrenheit(), 0.001);
    assertEquals(373.15, cTemp.inKelvin(), 0.001);
  }

  /**
   * Tests inCelsius, inFahrenheit, and inKelvin method work correctly when
   * Fahrenheit is 100.
   */
  @Test
  public void testInF() {
    assertEquals(100, fTemp.inCelsius(), 0.001);
    assertEquals(212, fTemp.inFahrenheit(), 0.001);
    assertEquals(373.15, fTemp.inKelvin(), 0.001);
  }

  @Test
  public void testAddCelsius() {
    Random random = new Random(98776);
    double expected;
    double actual;

    Temperature t1;
    Temperature t2;
    Temperature t3;

    double temp1;
    double temp2;

    for (int test = 0; test < 5000; test++) {
      temp1 = random.nextDouble() * 270 - 135;
      temp2 = random.nextDouble() * 270 - 135;

      t1 = new CelsiusTemperature(temp1);
      t2 = new CelsiusTemperature(temp2);

      t3 = t1.add(t2);
      expected = temp1 + temp2;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);

      t3 = t2.add(t1);
      expected = temp1 + temp2;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);
    }
  }

  /**
   * Test adding one CelsiusTemperature
   */
  @Test
  public void testAddFahrenheit() {
    Random random = new Random(98776);
    double expected;
    double actual;

    Temperature t1;
    Temperature t2;
    Temperature t3;

    double temp1;
    double temp2;

    for (int test = 0; test < 5000; test++) {
      temp1 = random.nextDouble() * 270 - 135;
      temp2 = random.nextDouble() * 270 - 135;

      t1 = new FahrenheitTemperature(temp1, true);
      t2 = new FahrenheitTemperature(temp2, true);

      t3 = t1.add(t2);
      expected = temp1 + temp2;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);

      t3 = t2.add(t1);
      expected = temp1 + temp2;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);
    }
  }

  /**
   * Test adding one CelsiusTemperature
   */
  @Test
  public void testAddMix() {
    Random random = new Random(98776);
    double expected;
    double actual;

    Temperature t1;
    Temperature t2;
    Temperature t3;

    double temp1;
    double temp2;

    for (int test = 0; test < 5000; test++) {
      temp1 = random.nextDouble() * 270 - 135;
      temp2 = random.nextDouble() * 270 - 135;

      t1 = new CelsiusTemperature(temp1);
      t2 = new FahrenheitTemperature(temp2, true);

      t3 = t1.add(t2);
      expected = temp1 + temp2;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);

      t3 = t2.add(t1);
      expected = temp1 + temp2;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);
    }

    for (int test = 0; test < 5000; test++) {
      temp1 = random.nextDouble() * 270 - 135;
      temp2 = 0;

      t1 = new CelsiusTemperature(temp1);
      t2 = new FahrenheitTemperature(temp2, true);

      t3 = t1.add(t2);
      expected = temp1;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);

      t3 = t2.add(t1);
      expected = temp1;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);
    }

    for (int test = 0; test < 5000; test++) {
      temp1 = random.nextDouble() * 270 - 135;
      temp2 = -temp1;

      t1 = new CelsiusTemperature(temp1);
      t2 = new FahrenheitTemperature(temp2, true);

      t3 = t1.add(t2);
      expected = 0;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);

      t3 = t2.add(t1);
      expected = 0;
      actual = t3.inCelsius();
      assertEquals(expected, actual, 0.001);
    }

    for (int test = 0; test < 5000; test++) {
      temp1 = random.nextDouble() * 270 - 135;
      temp2 = random.nextDouble() * -270 - (Temperature.ABS_ZERO_C - temp1);
      t1 = new CelsiusTemperature(temp1);
      t2 = new FahrenheitTemperature(temp2, true);

      try {
        t3 = t1.add(t2);
      } catch (IllegalArgumentException e) {
        fail("Should have added to below absolute 0");
      }

      try {
        t3 = t2.add(t1);
      } catch (IllegalArgumentException e) {
        fail("Should have added to below absolute 0");
      }

    }
  }

  @Test
  public void testToString() {
    assertEquals("100.0° Celsius", cTemp.toString());
    assertEquals("212.0° Fahrenheit", fTemp.toString());

    Random random = new Random(98776);
    double inTemp;
    String expected;
    String actual;

    Temperature t;
    for (int test = 0; test < 5000; test++) {
      inTemp = random.nextDouble() * 200;

      t = new CelsiusTemperature(inTemp);
      actual = t.toString();
      expected = String.format("%.1f° Celsius", inTemp);
      assertEquals(expected, actual);

      t = new FahrenheitTemperature(inTemp);
      actual = t.toString();
      expected = String.format("%.1f° Fahrenheit", inTemp);
      assertEquals(expected, actual);
    }
  }

  @Test
  public void testConvertFahrenheitToCelsius() {
    Random random = new Random(254234);
    double fahrenheit;
    double expected;
    for (int test = 0; test < 5000; test++) {
      fahrenheit = random.nextDouble() * 252 - 40;
      expected = (fahrenheit - 32.0) * (5.0 / 9.0);
      assertEquals(expected, AbstractTemperature.convertFahrenheitToCelsius(fahrenheit), 0.01);
    }
    assertEquals(100.0, AbstractTemperature.convertFahrenheitToCelsius(212.0), 0.01);
    assertEquals(0.0, AbstractTemperature.convertFahrenheitToCelsius(32), 0.01);
    assertEquals(-40.0, AbstractTemperature.convertFahrenheitToCelsius(-40.0), 0.01);

  }
}
