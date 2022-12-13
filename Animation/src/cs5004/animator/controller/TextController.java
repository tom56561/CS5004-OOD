package cs5004.animator.controller;

import java.io.IOException;

import cs5004.animator.model.InterfaceModel;
import cs5004.animator.view.InterfaceText;
import cs5004.animator.view.ViewType;

public class TextController implements InterfaceController {

  private InterfaceText view;
  private Appendable out;

  public TextController(InterfaceText view, InterfaceModel model, int speed, Appendable a) {
    this.out = a;
    this.view = view;
  }

  @Override
  public void start() {
    if (this.view.getViewType() == ViewType.TEXT) {
      this.view.printRender();
      try {
        this.out.append(this.view.render());
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}
