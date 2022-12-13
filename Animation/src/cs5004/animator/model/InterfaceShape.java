package cs5004.animator.model;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Shape Interface defines all the supported operations for each shape.
 * 
 * @author eddie
 *
 */
public interface InterfaceShape {

  /**
   * Return the name.
   * 
   * @return name
   */
  String getName();

  /**
   * Return the shape type.
   * 
   * @return the shape type
   */
  ShapeType getType();

  /**
   * Get the width of the shape.
   * 
   * @return the width of the shape
   */
  double getWidth();

  /**
   * Get height of the shape.
   * 
   * @return height of the shape
   */
  double getHeight();

  /**
   * Get the position of the shape.
   * 
   * @return the position of the shape
   */
  Point2D getPosition();

  /**
   * Get the time of shape will appear.
   * 
   * @return the time of shape will appear
   */
  int getAppear();

  /**
   * Get the time of shape will disappear.
   * 
   * @return the time of shape will disappear
   */
  int getDisappear();

  /**
   * Set the position of the shape by given Point2D.
   * 
   * @param point include x y of the position as a Point2D type
   */
  void setPosition(Point2D point);


  /**
   * Set the width of the shape by given width.
   * 
   * @param w the width that the shape should be changed to
   */
  void setWidth(double w);

  /**
   * Set the height of the shape by given height.
   * 
   * @param h the height that the shape should be changed to
   */
  void setHeight(double h);
  
  void setAppear(int t);
  
  void setDisappear(int t);
  
  double getGreen();
  
  double getRed();

  double getBlue();

  
  void setRed(double newRed);


  void setGreen(double newGreen);

 
  void setBlue(double newBlue);

}
