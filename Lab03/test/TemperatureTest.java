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

  // test more
  @Test(expected = IllegalArgumentException.class)
  public void testForInvalidFTemp() {
    new FahrenheitTemperature(-1000);
  }

  @Test
  public void testManyInvalidFTemp() {
    Random random = new Random(98776);
    double inTemp;
    for (int test = 0; test < 5000; test++) {
      inTemp = random.nextDouble() * 100;

      try {
        new CelsiusTemperature(Temperature.ABS_ZERO_C - inTemp);
        fail("Did not throw exception on temperature below abolute 0");
      } catch (IllegalArgumentException e) {
        // do nothing
      }
      try {
        new FahrenheitTemperature(Temperature.ABS_ZERO_C - inTemp, true);
        fail("Did not throw exception on temperature below abolute 0");
      } catch (IllegalArgumentException e) {
        // do nothing
      }
    }
  }

  @Test
  public void testObservers() {
    assertEquals(100, cTemp.inCelsius(), 0.001);
    assertEquals(212, cTemp.inFahrenheit(), 0.001);
    assertEquals(373.15, cTemp.inKelvin(), 0.001);
  }

  @Test
  public void testInF() {
    assertEquals(212, fTemp.inFahrenheit(), 0.001);
  }

  @Test
  public void testAdd() {
    // test your add() method here according to its specification
  }

  @Test
  public void testToString() {
    assertEquals("100.0Â° Celsius", cTemp.toString());
    assertEquals("212.0Â° Fahrenheit", fTemp.toString());
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
