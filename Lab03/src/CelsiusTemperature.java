
/**
 * CelsiusTemperature represents a temperature with units Celsius.
 * 
 * @author eddie
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
   * Return a String as follows: "NN.N° Celsius".
   */
  @Override
  public String toString() {
    return String.format("%.1f° Celsius", this.temperatureCelsius);
  }

  /**
   * Adds two temperature together by summing their temperature valuer in like
   * units, and returns a new CelsiusTemperature object with that temperature
   * value.
   */
  @Override
  public Temperature add(Temperature t) throws IllegalArgumentException {
    if (this.temperatureCelsius + t.inCelsius() < Temperature.ABS_ZERO_C) {
      throw new IllegalArgumentException("Can not add two temperature that result");
    }
    return new CelsiusTemperature(this.temperatureCelsius + t.inCelsius());
  }
}
