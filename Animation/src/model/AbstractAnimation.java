package model;

public class AbstractAnimation implements InterfaceAnimation {

  protected int startTime;
  protected int endTime;
  protected String name;
  protected AnimationType aniType;
  protected InterfaceShape shape;


  public AbstractAnimation(AnimationType aniType, String name, int startTime, int endTime, InterfaceShape s) {
    this.aniType = aniType;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
    this.shape = s;
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