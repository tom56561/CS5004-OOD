
/**
 * This class represents a Rectangle. A Rectangle has a x and a y.
 */
public class Rectangle {

  private int x;
  private int y;
  private int w;
  private int h;

  /**
   * Makes a new Rectangle object with the x and y.
   * 
   * @param x   the x of the Rectangle
   * @param y   the y of the Rectangle
   * @param w   the width of the Rectangle
   * @param h   the height of the Rectangle
   */
  public Rectangle(int x, int y, int w, int h) throws IllegalArgumentException {
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("width or height should not be negative");
    }
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

}
