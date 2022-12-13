import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.controller.TextController;
import cs5004.animator.model.InterfaceModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.ShapeType;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.InterfaceAnimation;
import cs5004.animator.view.InterfaceText;
import cs5004.animator.view.TextView;
import cs5004.animator.controller.InterfaceController;

public class ControllerTest {

  private InterfaceController animationcontroller;
  private InterfaceController textcontroller;
  private InterfaceModel model;
  private InterfaceAnimation view;
  private InterfaceText view2;
  private StringBuilder textLog;

  @Before
  public void setUp() throws Exception {
    textLog = new StringBuilder();
    model = new ModelImpl();
    view = new AnimationView(model.getBoundW(), model.getBoundH());
    view2 = new TextView(model, 10);
    animationcontroller = new AnimationController(model, view, 10);
    textcontroller = new TextController(view2, model, 10, textLog);

  }

  @Test
  public void testTextControllerStart() {
    textcontroller.start();
    assertEquals("Shape: \n", textLog.toString());
  }

  @Test
  public void testTextControllerStart2() {
    model.addShape("A", ShapeType.RECTANGLE, 0, 0, 1, 1, 1, 10, 20, 0, 100);
    textcontroller.start();
    assertEquals("Shape: \n" + "Name: A\n" + "Type: RECTANGLE\n"
        + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0, 1.0, 1.0)\n"
        + "Appears at time t=0 and disappears at time t=10\n", textLog.toString());
  }

  @Test
  public void testTextControllerStart3() {
    model.addShape("A", ShapeType.RECTANGLE, 0, 0, 1, 1, 1, 10, 20, 0, 100);
    model.move("A", 10, 20, 5, 5, 10, 10);
    textcontroller.start();
    assertEquals(
        "Shape: \n" + "Name: A\n" + "Type: RECTANGLE\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0, 1.0, 1.0)\n"
            + "Appears at time t=0 and disappears at time t=10\n"
            + "Shape A moves from (5.0,10.0) to (5.0,10.0), from time t=1 to t=2\n",
        textLog.toString());
  }

}
