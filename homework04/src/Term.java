
public class Term implements TermInterface {

  int coef;
  int pow;
  Term next;

  public Term(int coef, int pow, Term next) throws IllegalArgumentException {
    if (pow < 0) {
      throw new IllegalArgumentException("Power can not be a negative number");
    }
    this.coef = coef;
    this.pow = pow;
    this.next = next;
  }

  @Override
  public int getCoef() {
    return this.coef;
  }

  @Override
  public int getPow() {
    // TODO Auto-generated method stub
    return this.pow;
  }

  @Override
  public Term getNext() {
    // TODO Auto-generated method stub
    return next;
  }

  @Override
  public double evaluate(double x) {
    if (this.pow == 0) {
      return (double) this.coef;
    } else if (this.next == null) {
      return this.coef * ((double)Math.pow(x, this.pow));
    }
    return this.coef * ((double)Math.pow(x, this.pow)) + this.next.evaluate(x);
  }
  
  
  @Override
  public String toString() {
    if (this.pow == 0) {
      return this.coef + "";
    }
    else if (this.next == null) {
      return this.coef + "x^" + this.pow;
    }
    
    String operate = " +";
    if (this.next.coef < 0) {
      operate = " ";
    }
    return this.coef + "x^" + this.pow + operate + this.next.toString();
  }


}
