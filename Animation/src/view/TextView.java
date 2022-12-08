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


  }

}
