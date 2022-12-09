package view;

import model.InterfaceShape;

public interface InterfaceAnimation {
  
  void drawShape(InterfaceShape shape);
  
  ViewType getViewType();
  
  void refresh();
  
  
  
}
