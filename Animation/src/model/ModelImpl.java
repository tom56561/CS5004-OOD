package model;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A class ModelImpl that implements all methods from the InterfaceModel.
 * 
 * @author eddie
 *
 */
public class ModelImpl implements InterfaceModel {

  private Map<String, InterfaceShape> shapeMap;
  private Map<String, ArrayList<InterfaceAnimation>> animationMap;

  /**
   * Initialize the two map to store the shape and animation information.
   */
  public ModelImpl() {
    this.shapeMap = new LinkedHashMap<>();
    this.animationMap = new HashMap<>();
  }

  @Override
  public InterfaceShape getShape(String name) {
    return shapeMap.get(name);
  }

  @Override
  public ArrayList<InterfaceAnimation> getAnimation(String name) {
    return animationMap.get(name);
  }
  
  @Override
  public Map getShapeList() {
    Map<String, InterfaceShape> newShapeMap = new LinkedHashMap<>();
    for (String name: this.shapeMap.keySet()) {
      newShapeMap.put(name, shapeMap.get(name));
    }
    return newShapeMap;
  }

  @Override
  public void addShape(String name, ShapeType shapetype, double x, double y, int r1, int g1, int b1,
      double width, double height, int appearT, int disappearT) {

    Color color = new Color(r1, g1, b1);
    InterfaceShape shape = null;
    Point2D position = new Point2D.Double(x, y);
    if (shapetype == ShapeType.RECTANGLE) {
      shape = new Rectangle(name, shapetype, position, color, width, height, appearT, disappearT);
    } else if (shapetype == ShapeType.OVAL) {
      shape = new Oval(name, shapetype, position, color, width, height, appearT, disappearT);
    }
    if (shape != null) {
      this.shapeMap.put(name, shape);
      this.animationMap.put(name, new ArrayList<>());
    }

  }

  @Override
  public void changeColor(String name, int startTime, int endTime, int r1, int g1, int b1, int r2,
      int g2, int b2) {
    ChangeColor newColor = new ChangeColor(this.shapeMap, AnimationType.COLOR, name, startTime,
        endTime, r1, g1, b1, r2, g2, b2);
    newColor.setColor();

  }

  @Override
  public void changeScale(String name, int startTime, int endTime, double startW, double startH,
      double endW, double endH) {
    Scale newScale = new Scale(this.shapeMap, AnimationType.SCALE, name, startTime, endTime, startW,
        startH, endW, endH);
    newScale.setScale();
  }

  @Override
  public void move(String name, int startTime, int endTime, double startX, double endX,
      double startY, double endY) {
    Move newMove = new Move(this.shapeMap, AnimationType.SCALE, name, startTime, endTime, startX,
        startY, endX, endY);
    newMove.setMove();
    animationMap.get(name).add(newMove);

  }

}
