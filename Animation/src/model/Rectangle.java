package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public class Rectangle extends AbstractShape {

  /**
   * Initialize a rectangle by given arguments.
   * 
   * @param name       the name of this shape
   * @param shapetype  the type of the shape
   * @param position   the position of the shape
   * @param color      the color of the shape
   * @param width      the width of the shape
   * @param height     the height of the shape
   * @param appearT    the appearT of the shape
   * @param disappearT the disappearT of the shape
   * @throws IllegalArgumentException if the width and height is negative number
   *                                  or position is null
   */
  public Rectangle(String name, ShapeType shapetype, Point2D position, Color color, int width,
      int height, int appearT, int disappearT) throws IllegalArgumentException {
    super(name, shapetype, position, color, width, height, appearT, disappearT);
  }

  /**
   * Initialize a rectangle without argument.
   */
  public Rectangle() {
    super();
  }

}