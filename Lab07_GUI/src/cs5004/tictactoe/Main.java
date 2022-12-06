package cs5004.tictactoe;

import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * Run a Tic Tac Toe game interactively on the console.
 */
public class Main {
  /**
   * Run a Tic Tac Toe game interactively on the console.
   */
  public static void main(String[] args) {
//    new TicTacToeConsoleController(new InputStreamReader(System.in),
//        System.out).playGame(new TicTacToeModel());
    
    String message = "";
    for (int i = 0; i < args.length; i++) {
      message += args[i];
    }
    JOptionPane.showMessageDialog(null, message);
    
    new TicTacToeGUIController(new TicTacToeViewGUI()).playGame(new TicTacToeModel());
  }
}
