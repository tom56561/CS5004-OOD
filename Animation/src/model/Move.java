package model;

import java.awt.geom.Point2D;
import java.util.Map;

/**
 * The class represent move animation.
 * 
 * @author eddie
 *
 */
public class Move extends AbstractAnimation {

  private double startX;
  private double endX;
  private double startY;
  private double endY;

  /**
   * Construct that initialize the field by given arguments.
   * 
   * @param shapeMap  map name : shape
   * @param aniType   the animation type of shape
   * @param name      the name of shape
   * @param startTime the animation start time
   * @param endTime   the animation end time
   * @param startX    the start x position
   * @param startY    the start y position
   * @param endX      the end x position
   * @param endY      the ene y postion
   */
  public Move(Map shapeMap, AnimationType aniType, String name, int startTime, int endTime,
      double startX, double startY, double endX, double endY) {
    super(shapeMap, aniType, name, startTime, endTime);

    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;

  }

  /**
   * Change the postion.
   */
  public void setMove() {
    this.shape.setPosition(new Point2D.Double(this.endX, this.endY));
  }

  @Override
  public String toString() {
    return "Shape " + this.name + " moves from (" + this.startX + "," + this.startY + ") to ("
        + this.endX + "," + this.endY + ")";
  }

}
