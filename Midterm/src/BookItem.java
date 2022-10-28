/**
 * BookItem represents the book item in the web stores.
 * 
 * @author eddie
 *
 */
public class BookItem extends AbstractItem {

  private String title;
  private String author;
  private int length;

  /**
   * Create a new BookItem given an input author, title, length, price,
   * initialStock, and weight.
   * 
   * @param author       the author of the book
   * @param title        the title of the book
   * @param length       the length of the book
   * @param price        the price of the book
   * @param initialStock the stock of the book
   * @param weight       the weight of the book
   */
  public BookItem(String author, String title, int length, double price, double weight,
      int initialStock) {
    super(price, weight, initialStock);
    this.title = title;
    this.author = author;
    this.length = length;
  }

  /**
   * Return the title of the book.
   * 
   * @return the title of the book
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Return the author of the book.
   * 
   * @return the author of the book
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Return the length of the book.
   * 
   * @return the length of the book.
   */
  public int getLength() {
    return this.length;
  }

}
