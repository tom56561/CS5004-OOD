
public class PolynomialImpl implements Polynomial {

  private Term head;

  /**
   * A polynomial object with zero terms.
   */
  public PolynomialImpl() {
    this.head = null;
  }

  public PolynomialImpl(String polyno) throws IllegalArgumentException {
    String[] arr = polyno.split(" ");
    for (String s : arr) {
      if (s.contains("x")) {
//        String[] term = s.split(Pattern.quote("x^"));
        String coefS = s.substring(0, s.indexOf('x'));
        String powS = s.substring(s.indexOf('^') + 1);
        int coef = Integer.parseInt(coefS);
        int pow = Integer.parseInt(powS);
        if (pow < 0 || coef == 0) {
          throw new IllegalArgumentException(
              "Power can not be a negative number or coefficients can not be zero");
        }
        this.addTerm(coef, pow);
      } else {
        int coef = Integer.parseInt(s);
        if (coef == 0) {
          throw new IllegalArgumentException("Coefficients can not be zero");
        }
        this.addTerm(coef, 0);
      }
    }

  }

  @Override
  public void addTerm(int coef, int pow) throws IllegalArgumentException {
    if (pow < 0 || coef == 0) {
      throw new IllegalArgumentException(
          "Power can not be a negative number or coefficients can not be zero");
    }
    Term cur = head;
    Term node;
    Term temp;

    if (this.head == null) {
      head = new Term(coef, pow, null);
    } else if (pow > this.head.pow) {
      node = new Term(coef, pow, this.head);
      this.head = node;
    } else if (pow < cur.pow) {
      while (cur.next != null && cur.next.pow >= pow) {
        cur = cur.next;
      }
      if (cur.pow == pow) {
        cur.coef += coef;
      } else {
        temp = cur.next;
        cur.next = new Term(coef, pow, temp);
      }
    }
  }

  @Override
  public void removeTerm(int pow) throws IllegalArgumentException {
    if (pow < 0) {
      throw new IllegalArgumentException("Power can not be a negative number");
    }
    if (this.head.pow == pow) {
      this.head = this.head.next;
    }
    Term cur = this.head;
    while (cur.next != null && cur.next.pow != pow && cur.next.pow > pow) {
      cur = cur.next;
    }
    if (cur.next.pow == pow) {
      cur.next = cur.next.next;
    }
  }

  @Override
  public int getDegree() {
    if (this.head == null) {
      return 0;
    }
    return this.head.pow;
  }

  @Override
  public int getCoefficient(int pow) throws IllegalArgumentException {
    if (pow < 0) {
      throw new IllegalArgumentException("Power can not be a negative number");
    }
    Term cur = this.head;
    while (cur != null && cur.pow != pow && cur.pow > pow) {
      cur = cur.next;
    }
    if (cur.pow == pow) {
      if (cur.pow == pow) {
        return cur.coef;
      }
    }
    return 0;
  }

  @Override
  public double evaluate(double x) {
    if (this.head == null) {
      return 0;
    }
    return this.head.evaluate(x);
  }

  @Override
  public PolynomialImpl add(PolynomialImpl other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Other it is a different object");
    }
    PolynomialImpl sum = new PolynomialImpl();
    Term cur = this.head;
    Term oCur = other.head;
    
    while(cur != null) {
      sum.addTerm(cur.coef, cur.pow);
      cur = cur.next;
    }
    while(oCur != null) {
      sum.addTerm(oCur.coef, oCur.pow);
      oCur = oCur.next;
    }
    return sum;
  }

  @Override
  public String toString() {
    if (this.head == null) {
      return "0";
    }
    return this.head.toString();
  }

}
