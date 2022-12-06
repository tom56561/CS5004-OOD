package cs5004.tictactoe;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToeViewGUI extends JFrame implements TicTacToeView, ActionListener {
  
  private JMenuBar menuBar;
  private JMenu file;
  private JMenuItem exit;
  private JMenuItem newGame;
  private JPanel buttonPanel;
  private JTextField textField;
  private JButton moveButton;
  
  private JButton quitButton;
  
  private TicTacToePanel tttp;

  public TicTacToeViewGUI() {
    super("TicTacToe");
    this.setSize(500, 600);
    this.setLocation(0, 0);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);
    this.file = new JMenu("File");
    this.menuBar.add(this.file);
    this.exit = new JMenuItem("Exit");
    this.exit.setName("Quit");
    this.exit.addActionListener(this);
    this.file.add(this.exit);
    this.newGame = new JMenuItem("New Game");
    this.newGame.setName("New Game");
    this.file.add(this.newGame);
    this.newGame.addActionListener(this);

    
    this.tttp = new TicTacToePanel();
    
    this.add(this.tttp);
    
    this.buttonPanel = new JPanel(true);
    this.buttonPanel.setBackground(Color.WHITE);
    this.buttonPanel.setSize(500, 40);
    this.buttonPanel.setLocation(0, 0);
    this.buttonPanel.setLayout(new FlowLayout());
    
    this.moveButton = new JButton("Move");
    this.moveButton.setName("Move");
    this.buttonPanel.add(this.moveButton);
    this.moveButton.addActionListener(this);
    this.textField = new JTextField(5);
    this.buttonPanel.add(this.textField);
    
    this.quitButton = new JButton("Quit");
    this.quitButton.setName("Quit");
    this.quitButton.addActionListener(this);
    this.buttonPanel.add(this.quitButton);
    
    this.add(this.buttonPanel);

    this.tttp.repaint();
    this.setVisible(true);
  }

  
  
  @Override
  public void display(TicTacToeGUIController tttController) {
    this.moveButton.addActionListener(tttController);
    this.newGame.addActionListener(tttController);

  }



  @Override
  public void actionPerformed(ActionEvent e) {
    Component c = (Component) e.getSource();
    if (c.getName().equals("Quit")) {      
      System.exit(0);
    }
        
  }


  @Override
  public String getMoveCommand() {
    String command = this.textField.getText();
    this.textField.setText("");
    return command;
  }



  @Override
  public void showErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }



  @Override
  public void updateBoard(Player[][] board) {
    this.tttp.setBoard(board);
    this.tttp.repaint();

  }
  
  

}
