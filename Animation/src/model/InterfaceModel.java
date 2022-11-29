package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public interface InterfaceModel {
  InterfaceShape getShape(String name);

  void addShape(String name, ShapeType shapetype, Point2D position, Color color, double width,
      double height, int appearT, int disappearT);

  void changeColor(String name, int startTime, int endTime, InterfaceShape s, int r1, int g1,
      int b1, int r2, int g2, int b2);

  void changeScale(String name, int startTime, int endTime, InterfaceShape s, double startW,
      double startH, double endW, double endH);
  
  void move(AnimationType aniType, String name, int startTime, int endTime, InterfaceShape s,
      double startx, double endx, double starty, double endy);
}
