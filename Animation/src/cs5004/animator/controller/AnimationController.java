package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import cs5004.animator.view.InterfaceAnimation;
import cs5004.animator.model.InterfaceModel;
import cs5004.animator.model.InterfaceShape;

public class AnimationController implements InterfaceController {
  
  private Timer timer;

  public AnimationController(InterfaceModel model, InterfaceAnimation animationView, int speed) {
    this.timer = new Timer(1000 / speed, new ActionListener() {
      int currentFrame = 0;
      @Override
      public void actionPerformed(ActionEvent e) {

        if (currentFrame == model.getMaxEndingTime()) {
          timer.stop();
          return;
        }
        for (InterfaceShape renderShape : model.getAllShapes(currentFrame++)) {
          animationView.drawShape(renderShape);
        }
        animationView.refresh();
      }
      });
  }

  @Override
  public void start() {
    timer.start();
  }

}
