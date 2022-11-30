package model;

import java.awt.geom.Point2D;
import java.util.Map;

public class Move extends AbstractAnimation {

  private double startX;
  private double endX;
  private double startY;
  private double endY;

  public Move(Map shapeMap, AnimationType aniType, String name, int startTime, int endTime,
      double startX, double startY, double endX, double endY) {
    super(shapeMap, aniType, name, startTime, endTime);

    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;

  }

  public void setMove() {
    this.shape.setPosition(new Point2D.Double(this.endX, this.endY));
  }
  
  @Override
  public String toString() {
    return "Shape " + this.name + " moves from (" + this.startX  + "," + this.startY + ") to ("
            + this.endX + "," + this.endY + ")";
  }

}
