/**
 * This represents an abstract item that will be in a web store.
 * You are a developer for the web store and noticed that 
 * the original developer did not use proper abstraction.
 * You need to correct this problem.
 * You need to look at the specific items:
 * KitchenItem
 * ClothingItem
 * Book Item
 * 
 * and determine should be moved into the abstract class.
 * Then properly add javadoc to all methods in the 
 * abstract class and subclasses. 
 * You will need to turn in this file, along with the properly
 * modified version of the other files so that they can make use
 * of all the fields and methods of this AbstractClass. 
 * 
 *
 */
public abstract class AbstractItem {

  private double price;
  private double weight;
  private int nInStock;

  /**
   * Create a new AbstractItem given an input price, weight, and nInStock.
   * 
   * @param price    the price of the item.
   * @param weight   the weight of the item.
   * @param nInStock the nInStock of the item.
   */
  public AbstractItem(double price, double weight, int nInStock) {
    this.price = price;
    this.weight = weight;
    this.nInStock = nInStock;
  }

  /**
   * Return the price of the item.
   * 
   * @return the price of the item
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * Return the weight of the item.
   * 
   * @return the weight of the item
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * Return the number of stock is left.
   * 
   * @return the number of stock is left
   */
  public boolean inStock() {
    return nInStock > 0;
  }

  /**
   * Updated the stock by number of sold item.
   * 
   * @param nSold the number of sold item
   * @throws IllegalArgumentException if the number of stock left is less than the
   *                                  number of sold item.
   */
  public void sellItem(int nSold) throws IllegalArgumentException {
    if (nSold > this.nInStock) {
      throw new IllegalArgumentException("We cannot sell more than are in stock.");
    }
    this.nInStock = this.nInStock - nSold;
  }

  /**
   * Return the value of stock.
   * 
   * @return the value of stock
   */
  public double valueOfStock() {
    return price * nInStock;
  }

}
