
public class FahrenheitTemperature extends AbstractTemperature {

  /**
   * Create a new FahrenheitTemperature given an input temperature in degrees
   * Fahrenheit.
   * 
   * @param temperatureCelsius the temperature in units Fahrenheit
   */
  public FahrenheitTemperature(double temperatureFahrenheit) {
    super(AbstractTemperature.convertFahrenheitToCelsius(temperatureFahrenheit));
  }

  /**
   * Create a new FahrenheitTemperature given an input temperature in degrees
   * Celsius.
   * 
   * @param temperatureCelsius the temperature in units Celsius.
   * @param isCelsius          true if the temperature is in Celsius.
   */
  public FahrenheitTemperature(double temperatureCelsius, boolean isCelsius) {
    super(temperatureCelsius);
  }
  
  @Override
  public String toString() {
    return String.format("%.1f° Fahrenheit", this.inFahrenheit());
  }
}
