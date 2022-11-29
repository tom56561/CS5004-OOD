package model;

import java.awt.geom.Point2D;
import java.util.Map;

public class Move extends AbstractAnimation {

  private double startx;
  private double endx;
  private double starty;
  private double endy;

  public Move(Map shapeMap, AnimationType aniType, String name, int startTime, int endTime,
      double startx, double endx, double starty, double endy) {
    super(shapeMap, aniType, name, startTime, endTime);

    this.startx = startx;
    this.starty = starty;
    this.endx = endx;
    this.endy = endy;

  }

  public void setMove() {
    this.shape.setPosition(new Point2D.Double(this.endx, this.endy));
  }

}
