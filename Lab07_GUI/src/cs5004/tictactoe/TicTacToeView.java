package cs5004.tictactoe;

public interface TicTacToeView {
  
  /**
   * Display the user interface.
   */
  void display(TicTacToeGUIController tttController);
  
  /**
   * Gets the coordinates of the intended move from the view.
   * @return
   */
  String getMoveCommand();
  
  /**
   * 
   * @param board
   */
  void updateBoard(Player[][] board);
  
  /**
   * 
   * @param message
   */
  void showErrorMessage(String message);
}
