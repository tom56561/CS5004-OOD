package view;

import java.io.StringWriter;

import model.InterfaceModel;
import model.InterfaceShape;

public class TextView implements InterfaceText {
  private Appendable out;
  private ViewType viewType;
  private InterfaceModel model;

  public TextView(InterfaceModel model) {
    this.out = new StringWriter();
    this.model = model;
    this.viewType = ViewType.TEXT;

  }

  @Override
  public ViewType getViewType() {
    return this.viewType;
  }

  @Override
  public void render() {
    StringBuilder output = new StringBuilder();
    output.append("Shape: \n");
    for (Object name : model.getShapeList().keySet()) {
      InterfaceShape currentShape = model.getShape((String) name);
      output.append(currentShape.toString()).append("Appears at time t=")
          .append(currentShape.getAppear()).append(" adn disappears at time t=")
          .append(currentShape.getDisappear()).append("\n");
    }
    
    //Animation

  }

}
