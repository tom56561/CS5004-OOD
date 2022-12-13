package cs5004.animator;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.controller.InterfaceController;
import cs5004.animator.controller.TextController;
import cs5004.animator.model.AnimationBuilder;
import cs5004.animator.model.AnimationReader;
import cs5004.animator.model.Builder;
import cs5004.animator.view.InterfaceAnimation;
import cs5004.animator.model.InterfaceModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.InterfaceText;
import cs5004.animator.view.TextView;
import cs5004.animator.view.ViewType;

public class EasyAnimator {

  public static void main(String[] args) {

    InterfaceModel model = new ModelImpl();

    String fileName = "buildings.txt";
    String viewType = "visual";
    String out = "out.txt";
    String speed = "20";

    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-in")) {
        fileName = args[i + 1];
      } else if (args[i].equalsIgnoreCase("-view")) {
        viewType = args[i + 1];
      } else if (args[i].equalsIgnoreCase("-out")) {
        out = args[i + 1];
      } else if (args[i].equalsIgnoreCase("-speed")) {
        speed = args[i + 1];
      }
    }

    AnimationBuilder<InterfaceModel> myAnimationBuilder = new Builder(model);
    try {
      model = AnimationReader.parseFile(new FileReader(fileName), myAnimationBuilder);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, e);
      System.exit(0);

    }

    InterfaceAnimation view = null;
    InterfaceText view2 = null;
    if (viewType.equalsIgnoreCase("text")) {
      view2 = new TextView(model);
    } else if (viewType.equalsIgnoreCase("visual")) {
      view = new AnimationView(model.getBoundW(),
          model.getBoundH());
    }

    InterfaceController controller;
    if (view.getViewType() == ViewType.ANIMATION) {
      controller = new AnimationController(model, view, Integer.parseInt(speed));
    } else {
      controller = new TextController(view2, model, Integer.parseInt(speed));
    }

    controller.start();

  }

}
