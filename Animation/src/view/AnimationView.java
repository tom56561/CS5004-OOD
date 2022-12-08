package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.InterfaceShape;

public class AnimationView extends JFrame implements InterfaceAnimation {

  private Panel panel;
  private ViewType viewType;
  private Timer timer;
  private int tempo;


  public AnimationView(int w, int h) {
    super();
    this.viewType = ViewType.ANIMATION;
    panel = new Panel(w, h);
    add(panel);
    setSize(w, h);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setVisible(true);
    this.timer = new Timer();

    
  }

  @Override
  public void play() {
    this.setVisible(true);

  }

  @Override
  public void drawShape(InterfaceShape shape) {
    panel.drawShapes(shape);
    
  }

  @Override
  public ViewType getViewType() {
    return this.viewType;
  }

  @Override
  public void refresh() {
    panel.repaint();
  }

}
