
public abstract class AbstractTemperature implements Temperature {
  protected double temperatureCelsius;

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

  @Override
  public int compareTo(Temperature o) {
    // TODO Auto-generated method stub
    return 0;
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

  @Override
  public Temperature add(Temperature t) {
    // TODO Auto-generated method stub
    return null;
  }

}
