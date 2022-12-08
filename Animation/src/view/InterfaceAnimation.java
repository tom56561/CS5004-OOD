package view;

import model.InterfaceShape;

public interface InterfaceAnimation {

  void play();
  
  void drawShape(InterfaceShape shape);
  
  ViewType getViewType();
  
  void refresh();
  
  
  
}
