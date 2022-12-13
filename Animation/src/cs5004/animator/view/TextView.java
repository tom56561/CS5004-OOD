package cs5004.animator.view;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cs5004.animator.model.InterfaceModel;
import cs5004.animator.model.InterfaceShape;
import cs5004.animator.model.InterfaceAnimation;

public class TextView implements InterfaceText {
  private Appendable out;
  private ViewType viewType;
  private InterfaceModel model;
  private int speed;

  public TextView(InterfaceModel model, int speed) {
    this.out = new StringWriter();
    this.model = model;
    this.viewType = ViewType.TEXT;
    this.speed = speed;

  }

  @Override
  public ViewType getViewType() {
    return this.viewType;
  }

  @Override
  public String render() {
    StringBuilder output = new StringBuilder();
    output.append("Shape: \n");
    for (Object name : model.getShapeList().keySet()) {
      InterfaceShape currentShape = model.getShape((String) name);
      output.append(currentShape.toString()).append("Appears at time t=")
          .append(currentShape.getAppear() / this.speed).append(" and disappears at time t=")
          .append(currentShape.getDisappear() / this.speed).append("\n");
    }
    Map<String, ArrayList<InterfaceAnimation>> animationMap = model.getAllAnimationMap();
    for (ArrayList<InterfaceAnimation> animationList : animationMap.values()) {
      for (InterfaceAnimation animation : animationList) {
        output.append(animation.toString()).append(", from time t=")
            .append(animation.getStartTime() / this.speed).append(" to t=")
            .append(animation.getEndTime() / this.speed).append("\n");
      }
    }

    String res = String.valueOf(output);
    return res;
  }

  @Override
  public void printRender() {
    System.out.print(this.render());
  }

}
