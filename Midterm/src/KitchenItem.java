/**
 * KitchenItem represents the kitchen item in the web stores.
 * 
 * @author eddie
 *
 */
public class KitchenItem extends AbstractItem {

  /**
   * Create a new KitchenItem given an input price, initialStock, and weight.
   * 
   * @param price        the price of the item
   * @param initialStock the stock of the item
   * @param weight       the weight of the item
   */
  public KitchenItem(double price, double weight, int initialStock) {
    super(price, weight, initialStock);
  }

}
