
/**
 * This class represents AbstractTemperature. A AbstractTemperature has a
 * temperatureCelsius.
 */
public abstract class AbstractTemperature implements Temperature {
  protected double temperatureCelsius;

  /**
   * Create a new AbstractTemperature given an input temperature in degrees
   * Celsius.
   * 
   * @param temperatureCelsius the temperature in units Celsius
   * @throws IllegalArgumentException when temperature is below absolute 0
   */
  public AbstractTemperature(double temperatureCelsius) throws IllegalArgumentException {
    if (temperatureCelsius < Temperature.ABS_ZERO_C) {
      throw new IllegalArgumentException("temperature must be above absolute 0");
    }
    this.temperatureCelsius = temperatureCelsius;
  }

  /**
   * Takes a temperature value in degrees Fahrenheit and converts it to degrees
   * Celsius.
   * 
   * @param temperatureFahrenheit temperature in Fahrenheit
   * @return the temperature in Celsius
   */
  protected static double convertFahrenheitToCelsius(double temperatureFahrenheit) {
    return (temperatureFahrenheit - 32) * 5 / 9;
  }

  /**
   * Compare the two Temperature in Celsius.
   * 
   * @return 1 if this.temperatureCelsius > o.inCelsius(), vice versa
   */
  @Override
  public int compareTo(Temperature o) {
    if (this.temperatureCelsius > o.inCelsius()) {
      return 1;
    } else if (this.temperatureCelsius < o.inCelsius()) {
      return -1;
    } else {
      return 0;
    }
  }

  @Override
  public double inCelsius() {
    return this.temperatureCelsius;
  }

  @Override
  public double inFahrenheit() {
    return this.temperatureCelsius * (9.0 / 5.0) + 32.0;
  }

  @Override
  public double inKelvin() {
    return this.temperatureCelsius - Temperature.ABS_ZERO_C;
  }

}
