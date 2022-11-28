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

  protected ShapeType shapetype;
  protected Point2D position;
  protected Color color;
  protected int width;
  protected int height;
  protected int appearT;
  protected int disappearT;

  protected AbstractShape(ShapeType shapetype, Point2D position, Color color, int width, int height,
      int appearT, int disappearT) throws IllegalArgumentException {
    if (position == null || width < 0 || height < 0) {
      throw new IllegalArgumentException("Input data is invalid, cannot build a shape");
    }
    this.shapetype = shapetype;
    this.position = position;
    this.color = color;
    this.width = width;
    this.height = height;
    this.appearT = appearT;
    this.disappearT = disappearT;
  }

  @Override
  public ShapeType getType() {
    return this.shapetype;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
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
  public void setWidth(int w) {
    this.width = w;
  }

  @Override
  public void setHeight(int h) {
    this.height = h;
  }

}
