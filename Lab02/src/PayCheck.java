
/**
 * This class represents a PayCheck. A PayCheck has a totalPay and a name.
 *
 */
public class PayCheck {
  private final double totalPay;

  /**
   * Makes a new PayCheck object with the give name and pay rate and their hours
   * worked.
   * 
   * @param name        the name of the PayCheck
   * @param payRate     the PayCheck pay rate in dollars per hour
   * @param hoursWorked the PayCheck hoursWorked
   */
  public PayCheck(String name, double payRate, double hoursWorked) {
    this.totalPay = payRate * Math.min(hoursWorked, 40)
        + payRate * Math.max(0, hoursWorked - 40) * (1.5 * payRate);
  }

  /**
   * The PayCheck toString is represented by the totalPay of the employee.
   * 
   * @return the totalPay of this employee as a String
   */
  @Override
  public String toString() {
    return String.format("$%.2f", this.totalPay);
  }

  /**
   * The PayCheck getTotalPay is represented by the totalPay of the employee.
   * 
   * @return the totalPay of this employee as a double
   */
  public double getTotalPay() {
    return this.totalPay;
  }

}
