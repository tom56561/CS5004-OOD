
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
   * @throws IllegalArgumentException when temperature is below absolute 0
   */
  public CelsiusTemperature(double temperatureCelsius) throws IllegalArgumentException {
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
  
  /**
   * put
   */
  @Override
  public String toString() {
    return String.format("%.1f° Celsius", this.temperatureCelsius);
  }
}
