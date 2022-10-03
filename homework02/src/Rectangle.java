import java.util.NoSuchElementException;

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
   * @param x the x of the Rectangle
   * @param y the y of the Rectangle
   * @param w the width of the Rectangle
   * @param h the height of the Rectangle
   */
  public Rectangle(int x, int y, int w, int h) throws IllegalArgumentException {
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("width or height should not be negative");
    }
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  /**
   * Return true if this rectangle overlaps with other, false otherwise.
   * 
   * @param other the other Rectangle object
   * @return true if this rectangle overlaps with other, false otherwise
   */
  public boolean overlap(Rectangle other) {
    return this.x < other.x + other.w && other.x < this.x + this.w && this.y < other.y + other.h
        && other.y < this.y + this.h;
  }

  /**
   * Return a Rectangle object that represents the union of this rectangle and the
   * other rectangle.
   * 
   * @param other the other Rectangle object
   * @return a Rectangle object that represents the union of this rectangle and
   *         the other rectangle
   */
  public Rectangle intersect(Rectangle other) throws NoSuchElementException {
    if (!this.overlap(other)) {
      throw new NoSuchElementException();
    }
    int xL = Math.max(this.x, other.x);
    int xR = Math.min(this.x + this.w, other.x + other.w);
    int yB = Math.max(this.y, other.y);
    int yT = Math.min(this.y + this.h, other.y + other.h);

    return new Rectangle(xL, yB, xR - xL, yT - yB);
  }

  /**
   * Return a Rectangle object that represents the union of this rectangle and the
   * other rectangle.
   * 
   * @param other the other Rectangle object
   * @return a Rectangle object that represents the union of this rectangle and
   *         the other rectangle
   */
  public Rectangle union(Rectangle other) {
    int xL = Math.min(this.x, other.x);
    int xR = Math.max(this.x + this.w, other.x + other.w);
    int yB = Math.min(this.y, other.y);
    int yT = Math.max(this.y + this.h, other.y + other.h);

    return new Rectangle(xL, yB, xR - xL, yT - yB);

  }

  /**
   * The Rectangle toString is represented by the components of the Rectangle.
   * 
   * @return components of the Rectangle as a string
   */
  public String toString() {
    return String.format("x:%d, y:%d, w:%d, h:%d", this.x, this.y, this.w, this.h);
  }

}
