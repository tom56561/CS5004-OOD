package model;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModelImpl implements InterfaceModel {

  private Map<String, InterfaceShape> shapeMap;

  public ModelImpl() {
    this.shapeMap = new LinkedHashMap<>();
  }

  @Override
  public InterfaceShape getShape(String name) {
    return null;
  }

  @Override
  public void addShape(String name, ShapeType shapetype, double x, double y, Color color,
      double width, double height, int appearT, int disappearT) {

    InterfaceShape shape = null;
    Point2D position = new Point2D.Double(x, y);
    if (shapetype == ShapeType.RECTANGLE) {
      shape = new Rectangle(name, shapetype, position, color, width, height, appearT, disappearT);
    } else if (shapetype == ShapeType.OVAL) {
      shape = new Oval(name, shapetype, position, color, width, height, appearT, disappearT);
    }
    if (shape != null) {
      this.shapeMap.put(name, shape);
    }

  }

  @Override
  public void changeColor(String name, int startTime, int endTime, int r1, int g1, int b1, int r2,
      int g2, int b2) {
    InterfaceAnimation newColor = new ChangeColor(this.shapeMap, AnimationType.COLOR, name,
        startTime, endTime, r1, g1, b1, r2, g2, b2);
  }

  @Override
  public void changeScale(String name, int startTime, int endTime, double startW,
      double startH, double endW, double endH) {
    InterfaceAnimation newScale = new Scale(this.shapeMap, AnimationType.SCALE, name,
        startTime, endTime, startW, startH, endW, endH);

  }

  @Override
  public void move(AnimationType aniType, String name, int startTime, int endTime, double startX,
      double endX, double startY, double endY) {
    InterfaceAnimation newMove = new Move(this.shapeMap, AnimationType.SCALE, name,
        startTime, endTime, startX, endX, startY, endY);

  }

}
