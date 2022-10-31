
/**
 * This class represents an Employee. An Employee has a name, a payRate and a
 * hoursWorked.
 */
public class Employee {
  private String name;
  private double payRate;
  private double hoursWorked;

  
  
  /**
   * Makes a new employee object with the give name and pay rate and sets their
   * hours worked so far to 0.
   * 
   * @param name    the name of the employee
   * @param payRate the employee's pay rate in dollars per hour
   */
  public Employee(String name, double payRate) {
    this.name = name;
    this.payRate = payRate;
    this.hoursWorked = 0;
  }

  /**
   * Return the name of this employee.
   * 
   * @return the name of this employee as a String
   */
  public String getName() {
    return this.name;
  }

  /**
   * Return this employee's pay rate in dollars per hour.
   * 
   * @return the pay rate for this employee
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Return the work hours of the employee.
   * 
   * @return the work hours of the employee
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }

  /**
   * Adds the new number of hours to the existing number of hours worked.
   * 
   * @param newHours the new hours worked, given in hours.
   */
  public void addHoursWorked(double newHours) {
    this.hoursWorked += newHours;
  }

  /**
   * Reset the hours to the existing number of hours worked.
   * 
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }

  /**
   * Gets the current week's paycheck for this employee.
   * 
   * @return a PayChek for this week's hours.
   */
  public PayCheck getWeeklyCheck() {
    return new PayCheck(this.name, this.payRate, this.hoursWorked);
  }

  /**
   * The employee toString is represented by the name of the employee.
   * 
   * @return the name of this employee as a String
   */
  public String toString() {
    return this.getName();
  }

}
