
/**
 * CelsiusTemperature represents a temperature with units Celsius.
 * 
 * @author eddie
 *
 */

public class CelsiusTemperature extends AbstractTemperature {

  /**
   * Create a new CelsiusTemperature given an input temperature in degrees
   * Celsius.
   * 
   * @param temperatureCelsius the temperature in units Celsius
   */
  public CelsiusTemperature(double temperatureCelsius) {
    super(temperatureCelsius);
  }

  /**
   * Create a new CelsiusTemperature given an input temperature in degrees
   * Fahrenheit.
   * 
   * @param temperatureFahrenheit the temperature in units Fahrenheit.
   * @param isFahrenheit          true if the temperature is in Fahrenheit.
   */
  public CelsiusTemperature(double temperatureFahrenheit, boolean isFahrenheit) {
    super(AbstractTemperature.convertFahrenheitToCelsius(temperatureFahrenheit));
  }
}
