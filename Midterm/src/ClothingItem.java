/**
 * ClothingItem represents the clothing item in the web stores.
 * 
 * @author eddie
 *
 */
public class ClothingItem extends AbstractItem {

  private Collection collection;

  /**
   * Create a new ClothingItem given an input price, size, collection, and
   * initialStock.
   * 
   * @param price        the price of the item
   * @param size         the weight of the item
   * @param collection   the collection of the item
   * @param initialStock the stock of the item
   */
  public ClothingItem(double price, double size, int initialStock, Collection collection) {
    super(price, size, initialStock);
    this.collection = collection;
  }

  /**
   * Return the collection of the item.
   * 
   * @return the collection of the item
   */
  public Collection getCollection() {
    return this.collection;
  }

}
