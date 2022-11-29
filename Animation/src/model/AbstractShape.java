package model;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * AbstractShape is abstract class for shape and implement all method in shape
 * interface. The class will be extended by rectangle and oval.
 * 
 * @author eddie
 *
 */
public class AbstractShape implements InterfaceShape {

  protected String name;
  protected ShapeType shapetype;
  protected Point2D position;
  protected Color color;
  protected double width;
  protected double height;
  protected int appearT;
  protected int disappearT;

  /**
   * Construct that initialize the field by given arguments.
   * 
   * @param name       the name of this shape
   * @param shapetype  the shapetype of the shape
   * @param position   the position of the shape
   * @param color      the color of the shape
   * @param width      the width of the shape
   * @param height     the height of the shape
   * @param appearT    the appearT of the shape
   * @param disappearT the disappearT of the shape
   * @throws IllegalArgumentException if the width and height is negative number
   *                                  or position is null
   */
  protected AbstractShape(String name, ShapeType shapetype, Point2D position, Color color,
      double width, double height, int appearT, int disappearT) throws IllegalArgumentException {
    if (position == null || width < 0 || height < 0) {
      throw new IllegalArgumentException("Input data is invalid, cannot build a shape");
    }
    this.name = name;
    this.shapetype = shapetype;
    this.position = position;
    this.color = color;
    this.width = width;
    this.height = height;
    this.appearT = appearT;
    this.disappearT = disappearT;
  }

  /**
   * Construct that initialize the field without argument passed in.
   */
  protected AbstractShape() {
    this("default", ShapeType.RECTANGLE, new Point2D.Double(0, 0), new Color(0), 0, 0, 0, 0);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeType getType() {
    return this.shapetype;
  }

  @Override
  public Color getColor() {
    return new Color(this.color.getRGB());
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public Point2D getPosition() {
    return this.position;
  }

  @Override
  public int getAppear() {
    return this.appearT;
  }

  @Override
  public int getDisappear() {
    return this.disappearT;
  }

  @Override
  public void setPosition(Point2D point) {
    this.position = point;
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public void setWidth(double w) {
    if (w < 0) {
      throw new IllegalArgumentException("Can not pass a negative width");
    }
    this.width = w;
  }

  @Override
  public void setHeight(double h) {
    if (h < 0) {
      throw new IllegalArgumentException("Can not pass a negative height");
    }
    this.height = h;
  }

  @Override
  public String toString() {
    return "Name: " + this.getName() + "\nType: " + this.getType().toString() + "\nMin corner: ("
        + this.position.getX() + "," + this.position.getY() + "), Width: " + this.getWidth()
        + ", Height: " + this.getHeight() + ", Color: (" + this.getColor() + ")\n";
  }

}
