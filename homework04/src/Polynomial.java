/**
 * The Polynomial interface defines all the supported operations for each
 * Polynomial.
 * 
 * @author eddie
 *
 */
public interface Polynomial {

  /**
   * Takes a coefficient and a power (both integer numbers) and adds the resulting
   * term to the polynomial.
   * 
   * @param coef the coefficient
   * @param pow  the power
   * @throws IllegalArgumentException if a negative power is passed to it or coef
   *                                  is zero
   */
  void addTerm(int coef, int pow) throws IllegalArgumentException;

  /**
   * Takes a power and removes any and all terms in the polynomial with that
   * power.
   * 
   * @param pow the power
   * @throws IllegalArgumentException if a negative power is passed to it
   * 
   */
  void removeTerm(int pow) throws IllegalArgumentException;

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
   * @throws IllegalArgumentException if a negative power is passed to it
   */
  int getCoefficient(int pow) throws IllegalArgumentException;

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

  Polynomial add(PolynomialImpl other) throws IllegalArgumentException;

}
