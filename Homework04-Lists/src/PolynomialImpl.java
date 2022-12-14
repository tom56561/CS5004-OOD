/**
 * PolynomialImpl represents Polynomial implement with linked list term.
 * 
 * @author eddie
 */
public class PolynomialImpl implements Polynomial {

  private Term head;

  /**
   * A polynomial object with zero terms.
   */
  public PolynomialImpl() {
    this.head = null;
  }

  /**
   * Makes a new PolynomialImpl object with the given polynomial as a string.
   * 
   * @param polyno the polynomial as a string
   * @throws IllegalArgumentException if powder is a negative number or
   *                                  coefficients is zero
   */
  public PolynomialImpl(String polyno) throws IllegalArgumentException {
    String[] arr = polyno.split(" ");
    for (String s : arr) {
      if (s.contains("x")) {
        String coefS = s.substring(0, s.indexOf('x'));
        String powS = s.substring(s.indexOf('^') + 1);
        int coef = Integer.parseInt(coefS);
        int pow = Integer.parseInt(powS);
        if (pow < 0) {
          throw new IllegalArgumentException("Power can not be a negative number");
        }
        this.addTerm(coef, pow);
      } else {
        int coef = Integer.parseInt(s);
        this.addTerm(coef, 0);
      }
    }

  }

  @Override
  public void addTerm(int coef, int pow) throws IllegalArgumentException {
    if (pow < 0) {
      throw new IllegalArgumentException("Power can not be a negative number");
    }
    Term cur = head;
    Term node;
    Term temp;

    if (this.head == null) {
      head = new Term(coef, pow, null);
    } else if (pow > this.head.pow) {
      node = new Term(coef, pow, this.head);
      this.head = node;
    } else if (pow <= cur.pow) {
      if (cur.pow == pow && (cur.coef + coef) == 0) {
        head = null;
      }
      while (cur.next != null && cur.next.pow >= pow) {
        if (cur.next.pow == pow && (cur.next.coef + coef) == 0) {
          cur.next = cur.next.next;
        }
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
  public void removeTerm(int pow) {
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
  public int getCoefficient(int pow) {
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
  public Term getHead() {
    return this.head;
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Other it is a different object");
    }
    Polynomial sum = new PolynomialImpl();

//    PolynomialImpl other2 = (PolynomialImpl) other;
//    Term oCur = other2.head;
    Term oCur = other.getHead();
    Term cur = this.head;

    while (cur != null || oCur != null) {
      if (oCur == null || (cur != null && cur.pow > oCur.pow)) {
        sum.addTerm(cur.coef, cur.pow);
        cur = cur.next;
      } else if (cur == null || (oCur != null && oCur.pow > cur.pow)) {
        sum.addTerm(oCur.coef, oCur.pow);
        oCur = oCur.next;
      } else {
        if (cur.coef + oCur.coef != 0) {
          sum.addTerm(cur.coef + oCur.coef, cur.pow);
        }
        cur = cur.next;
        oCur = oCur.next;
      }
    }

//    return new  PolynomialImpl(this.toString() + " -+" + other.toString());
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
    
