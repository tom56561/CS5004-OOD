package cs5004.tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TicTacToeModel implements TicTacToe {

  private Player[][] board;
    
  public TicTacToeModel() {
    this.board = new Player[3][3];
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using 
    // the helpful built-in String.join method.
    /**********
    List<String> rows = new ArrayList<>();
    for(Player[] row : getBoard()) {
      List<String> rowStrings = new ArrayList<>();
      for(Player p : row) {
        if(p == null) {
          rowStrings.add(" ");
        } else {
          rowStrings.add(p.toString());
        }
      }
      rows.add(" " + String.join(" | ", rowStrings));
    }
    return String.join("\n-----------\n", rows);
    ************/
  }

  @Override
  public void move(int r, int c) {
    if (this.isGameOver()) {
      throw new IllegalArgumentException("Cannot make a move after the game is over");
    }
    if(r < 0 || c < 0 || r > 2 || c > 2) {
      throw new IllegalArgumentException("Cannot get a mark that is off the board.");
    }
    
    if (this.getMarkAt(r, c) == Player.X || this.getMarkAt(r, c) == Player.O ) {
      throw new IllegalArgumentException("Cannot move to a spot that is already occupied.");
    }
    this.board[r][c] = this.getTurn();
  }

  @Override
  public Player getTurn() {  
    int xTotal = 0;
    int oTotal = 0;
    
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (this.getMarkAt(row, col) == Player.X) {
          xTotal++;
        }else if(this.getMarkAt(row, col) == Player.O) {
          oTotal++;
        }
      }
    }
    
    if (oTotal < xTotal) {
      return Player.O;
    }
    return Player.X;
  }

  @Override
  public boolean isGameOver() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Player getWinner() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Player[][] getBoard() {
    return this.board;
  }

  @Override
  public Player getMarkAt(int r, int c) throws IllegalArgumentException {
    if(r < 0 || c < 0 || r > 2 || c > 2) {
      throw new IllegalArgumentException("Cannot get a mark that is off the board");
    }
    return this.board[r][c];
  }
}
