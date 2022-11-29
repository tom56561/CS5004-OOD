package model;

public class ChangeColor extends AbstractAnimation {

  private double startW;
  private double startH;
  private double endW;
  private double endH;

  public ChangeColor(AnimationType aniType, String name, int startTime, int endTime,
      InterfaceShape s, double startW, double startH, double endW, double endH) {
    super(aniType, name, startTime, endTime, s);
    this.startW = startW;
    this.startH = startH;
    this.endW = endW;
    this.endH = endH;
  }

}
