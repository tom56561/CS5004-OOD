package cs5004.animator.controller;

import cs5004.animator.model.InterfaceModel;
import cs5004.animator.view.InterfaceText;
import cs5004.animator.view.ViewType;

public class TextController implements InterfaceController {

  private InterfaceText view;
  
  public TextController(InterfaceText view, InterfaceModel model, int speed) {
    this.view = view;
  }

  @Override
  public void start() {
    if(this.view.getViewType() == ViewType.TEXT){
      this.view.render();
    }

  }

}
