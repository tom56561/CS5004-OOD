package model;

public class AbstractAnimation implements InterfaceAnimation {

  protected int startTime;
  protected int endTime;
  protected String name;
  protected AnimationType aniType;

  
  
  public AbstractAnimation(AnimationType aniType, String name, int startTime, int endTime) {
    this.aniType = aniType;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
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
