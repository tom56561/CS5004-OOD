package cs5004.tictactoe;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TicTacToeViewGUI extends JFrame implements TicTacToeView {
  
  private JMenuBar menuBar;
  private JMenu file;
  private JMenuItem exit;

  public TicTacToeViewGUI() {
    super("TicTacToe");
    this.setSize(500, 500);
    this.setLocation(0, 0);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);
    this.file = new JMenu("File");
    this.menuBar.add(this.file);
    this.exit = new JMenuItem("Exit");
    this.file.add(this.exit);
    
    this.setVisible(true);
  }

  
  
  @Override
  public void display(TicTacToeGUIController tttController) {
    // TODO Auto-generated method stub

  }

}
