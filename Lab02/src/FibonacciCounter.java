
/**
 * A FibonacciCounter represents how far along we are in the Fibonacci sequence.
 * It has a minimum value of 0.
 * 
 * @author eddie
 *
 */
public class FibonacciCounter {
  private final int count;

  /**
   * Makes a new FibonacciCounter object with the count.
   * 
   * @param initialCount the count of the FibonacciCounter
   */
  public FibonacciCounter(int initialCount) {
    this.count = initialCount;
  }

  /**
   * Returns the Fibonacci Number for current count.
   * 
   * @return the count number in the Fibonacci Sequence
   */
  public int getFibonacciNumber() {

    double sqrtFive = Math.sqrt(5);
    Double fibValue = new Double((1 / sqrtFive)
        * (Math.pow((1 + sqrtFive) / 2, this.count) - Math.pow((1 - sqrtFive) / 2, this.count)));
    return fibValue.intValue();
  }

  /**
   * Returns a FibonacciCounter object with its count incremented by 1.
   * 
   * @return a FibonacciCounter object with its count incremented by 1.
   */
  public FibonacciCounter incrementedBy1() {
    FibonacciCounter result = new FibonacciCounter(this.count + 1);
    return result;
  }

  /**
   * Returns a FibonacciCounter object with its count decremented by 1.
   * 
   * @return a FibonacciCounter object with its count decremented by 1.
   */
  public FibonacciCounter decrementedBy1() {
    if (this.count > 0) {
      return new FibonacciCounter(this.count - 1);
    } else {
      return new FibonacciCounter(this.count);
    }
  }

  /**
   * Returns the current count of the counter.
   * 
   * @return the current count of the counter.
   */
  public int getCount() {
    return this.count;
  }

  /**
   * Returns the Fibonacci number corresponding to the current count.
   * 
   * @return the Fibonacci number corresponding to the current count.
   */
  public String getCountAndFib() {
    String result = String.format("(count:%d, fib:%d)", this.count, this.getFibonacciNumber());
    return result;
  }

}
