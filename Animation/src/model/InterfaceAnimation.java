package model;

/**
 * Animation Interface defines all the supported operations for each animation.
 * 
 * @author eddie
 *
 */
public interface InterfaceAnimation {

  /**
   * Get the name of the shape.
   * 
   * @return the name of the shape
   */
  String getName();

  /**
   * Get the type of the shape.
   * 
   * @return the type of the shape
   */
  AnimationType getType();

  /**
   * Get the start time of the shape.
   * 
   * @return the start time of the shape
   */
  int getStartTime();

  /**
   * Get the end time of the shape.
   * 
   * @return the end time of the shape
   */
  int getEndTime();

}
