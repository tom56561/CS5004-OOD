package model;

import java.awt.Color;
import java.util.Map;

public class ChangeColor extends AbstractAnimation implements InterfaceAnimation {

  private Color oldColor;
  private Color newColor;
 

  public ChangeColor(Map shapeMap, AnimationType aniType, String name, int startTime, int endTime,
      int r1, int g1, int b1, int r2, int g2, int b2) {
    super(shapeMap, aniType, name, startTime, endTime);
    
    this.oldColor = new Color(r1, g1, b1);
    this.newColor = new Color(r2, g2, b2);
  }
  
  public void setColor() {
    this.shape.setColor(newColor);
  }

}
