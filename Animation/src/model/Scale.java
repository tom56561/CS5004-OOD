package model;

import java.awt.geom.Point2D;
import java.util.Map;

public class Scale extends AbstractAnimation {
  private double startW;
  private double startH;
  private double endW;
  private double endH;

  public Scale(Map shapeMap, AnimationType aniType, String name, int startTime, int endTime,
      double startW, double startH, double endW, double endH) {
    super(shapeMap, aniType, name, startTime, endTime);
    this.startW = startW;
    this.startH = startH;
    this.endW = endW;
    this.endH = endH;
  }

  public void setScale() {
    this.shape.setHeight(this.endH);
    this.shape.setWidth(this.endW);
  }

}
