package model;

import java.awt.geom.Point2D;

public class Scale extends AbstractAnimation {
  private double startW;
  private double startH;
  private double endW;
  private double endH;

  public Scale(AnimationType aniType, String name, int startTime, int endTime,
      InterfaceShape s, double startW, double startH, double endW, double endH) {
    super(aniType, name, startTime, endTime, s);
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