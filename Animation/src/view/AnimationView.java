package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import model.InterfaceShape;

public class AnimationView extends JFrame implements InterfaceView {

  public AnimationView() throws HeadlessException {
    // TODO Auto-generated constructor stub
  }

  public AnimationView(GraphicsConfiguration gc) {
    super(gc);
    // TODO Auto-generated constructor stub
  }

  public AnimationView(String title) throws HeadlessException {
    super(title);
    // TODO Auto-generated constructor stub
  }

  public AnimationView(String title, GraphicsConfiguration gc) {
    super(title, gc);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void render() {
    // TODO Auto-generated method stub

  }

  @Override
  public void drawShape(InterfaceShape shape) {
    // TODO Auto-generated method stub

  }

  @Override
  public String getViewType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void refresh() {
    // TODO Auto-generated method stub

  }

}
