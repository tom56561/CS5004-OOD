package cs5004.animator.view;

import cs5004.animator.model.InterfaceShape;

public interface InterfaceAnimation {

  void drawShape(InterfaceShape shape);

  ViewType getViewType();

  void refresh();

}
