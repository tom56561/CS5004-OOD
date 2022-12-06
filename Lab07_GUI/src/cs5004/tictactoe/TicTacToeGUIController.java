package cs5004.tictactoe;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUIController implements TicTacToeController, ActionListener {
  TicTacToeView view;
  TicTacToe model;
  
  public TicTacToeGUIController(TicTacToeView tv) {
    this.view = tv;
    this.model = null;
  }

  @Override
  public void playGame(TicTacToe m) {
    this.model = m;
    this.view.updateBoard(this.model.getBoard());
    this.view.display(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Component c = (Component) e.getSource();
    if(c.getName().equals("Move")) {
      String command = this.view.getMoveCommand();
      int coord1 = Integer.parseInt("" + command.charAt(0));
      int coord2 = Integer.parseInt("" + command.charAt(2));
      
      try {
        this.model.move(coord1 - 1, coord2 - 1);
        this.view.updateBoard(this.model.getBoard());
        
      }catch(IllegalArgumentException exception){
        this.view.showErrorMessage(exception.getMessage());
      }catch(IllegalStateException exception){
        this.view.showErrorMessage(exception.getMessage());
      }
      
      if (this.model.isGameOver()) {
        String outString = "";
        outString += this.model.toString() + "\n";
        outString += "Game is over! ";
        if (this.model.getWinner() == Player.X) {
          outString += "X Wins.";
        } else if (this.model.getWinner() == Player.O) {
          outString += "O Wins.";
        } else {
          outString += "Tie game.";
        }
        
        this.view.showErrorMessage(outString);

      } else if (c.getName().equals("New Game")) {
        this.model = new TicTacToeModel();
        this.view.updateBoard(this.model.getBoard());
      }
      

    }
  }

}
