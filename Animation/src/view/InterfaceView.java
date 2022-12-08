package view;

import model.InterfaceShape;

public interface InterfaceView {

  void render();
  
  void drawShape(InterfaceShape shape);
  
  String getViewType();
  
  void refresh();
  
  
  
}
