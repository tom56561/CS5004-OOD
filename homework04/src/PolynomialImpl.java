
public class PolynomialImpl implements Polynomial {

  private int coef;
  private int pow;
  private PolynomialImpl next;

  /**
   * 0
   */
  public PolynomialImpl() {
  }

  public PolynomialImpl(String polyno) throws IllegalArgumentException {
    if (coef == 0) {
      throw new IllegalArgumentException("Coefficients can not be zero");
    }

  }

  @Override
  public void addTerm(int coef, int pow) throws IllegalArgumentException {
    if (pow < 0) {
      throw new IllegalArgumentException("Power can not be a negative number");
    }
    
    if(this.pow = 0)
    this.coef = coef;
    this.pow = pow;
  }

  @Override
  public void removeTerm(int pow) {
    // TODO Auto-generated method stub

  }

  @Override
  public int getDegree() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getCoefficient(int pow) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double evaluate(double x) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public PolynomialImpl add(PolynomialImpl other) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    return null;
  }

}
