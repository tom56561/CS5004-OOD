
public abstract class AbstractTemperature implements Temperature {
  protected double temperatureCelsius;

  public AbstractTemperature(double temperatureCelsius) {
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
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double inKelvin() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Temperature add(Temperature t) {
    // TODO Auto-generated method stub
    return null;
  }

}
