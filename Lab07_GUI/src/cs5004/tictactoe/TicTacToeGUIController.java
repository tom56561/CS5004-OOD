package cs5004.tictactoe;

public class TicTacToeGUIController implements TicTacToeController {
  TicTacToeView view;
  TicTacToe model;
  
  public TicTacToeGUIController(TicTacToeView tv) {
    this.view = tv;
    this.model = null;
  }

  @Override
  public void playGame(TicTacToe m) {
    this.model = m;
  }

}
