package model;

import java.util.Map;

public class AbstractAnimation implements InterfaceAnimation {

  protected int startTime;
  protected int endTime;
  protected String name;
  protected AnimationType aniType;
  protected InterfaceShape shape;
  protected Map shapeMap;

  public AbstractAnimation(Map shapeMap, AnimationType aniType, String name, int startTime,
      int endTime) {
    this.shapeMap = shapeMap;
    this.aniType = aniType;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
    this.shape = (InterfaceShape) this.shapeMap.get(this.name);
;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public AnimationType getType() {
    return this.aniType;
  }

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

}
