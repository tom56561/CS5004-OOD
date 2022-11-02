/**
 * The Polynomial interface defines all the supported operations for each
 * Polynomial.
 * 
 * @author eddie
 *
 */
public interface Polynomial {

  /**
   * Get head term of the Polynomial.
   * 
   * @return the head of the Polynomial
   */
  Term getHead();

  /**
   * Takes a coefficient and a power (both integer numbers) and adds the resulting
   * term to the polynomial.
   * 
   * @param coef the coefficient
   * @param pow  the power
   * @throws IllegalArgumentException if a negative power is passed to it
   */
  void addTerm(int coef, int pow) throws IllegalArgumentException;

  /**
   * Takes a power and removes any and all terms in the polynomial with that
   * power.
   * 
   * @param pow the power
   * 
   */
  void removeTerm(int pow);

  /**
   * Returns the degree of this polynomial.
   * 
   * @return the degree of this polynomial
   */
  int getDegree();

  /**
   * Takes a power and returns the coefficient for the term with that power.
   * 
   * @param pow the power
   * @return the coefficient for the term with that power
   */
  int getCoefficient(int pow);

  /**
   * Takes a double-precision decimal number and returns a double-precision
   * result.
   * 
   * @param x the x is a double-precision decimal number
   * @return a double-precision result
   */
  double evaluate(double x);

  /**
   * Takes another Polynomial object and returns the polynomial obtained by adding
   * the two polynomials.
   * 
   * @param other the another Polynomial object
   * @return the polynomial obtained by adding the two polynomials
   * @throws IllegalArgumentException if given Polynomial is different class
   */

  Polynomial add(Polynomial other) throws IllegalArgumentException;

}
