package model;

import java.awt.Color;

public class ChangeColor extends AbstractAnimation {

  private Color oldColor;
  private Color newColor;

  public ChangeColor(AnimationType aniType, String name, int startTime, int endTime,
      InterfaceShape s, int r1, int g1, int b1, int r2, int g2, int b2) {
    super(aniType, name, startTime, endTime, s);
    this.oldColor = new Color(r1, g1, b1);
    this.newColor = new Color(r2, g2, b2);

  }
  
  public void setColor() {
    this.shape.setColor(newColor);
  }

}
