package cs5004.tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * TicTacToeModel represents a TicTacToe implement.
 * 
 * @author eddie
 *
 */
public class TicTacToeModel implements TicTacToe {

  private Player[][] board;
  private Player winner;

  /**
   * Constructor take no parameters.
   */
  public TicTacToeModel() {
    this.board = new Player[3][3];
    this.winner = null;
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays
        .stream(getBoard()).map(row -> " " + Arrays.stream(row)
            .map(p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
        .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using
    // the helpful built-in String.join method.
    /**********
     * List<String> rows = new ArrayList<>(); for(Player[] row : getBoard()) {
     * List<String> rowStrings = new ArrayList<>(); for(Player p : row) { if(p ==
     * null) { rowStrings.add(" "); } else { rowStrings.add(p.toString()); } }
     * rows.add(" " + String.join(" | ", rowStrings)); } return
     * String.join("\n-----------\n", rows);
     ************/
  }

  @Override
  public void move(int r, int c) {
    if (this.isGameOver()) {
      throw new IllegalArgumentException("Cannot make a move after the game is over");
    }
    if (r < 0 || c < 0 || r > 2 || c > 2) {
      throw new IllegalArgumentException("Cannot get a mark that is off the board.");
    }

    if (this.getMarkAt(r, c) == Player.X || this.getMarkAt(r, c) == Player.O) {
      throw new IllegalArgumentException("Cannot move to a spot that is already occupied.");
    }
    this.board[r][c] = this.getTurn();

    if ((this.board[r][0] == this.board[r][1] && this.board[r][1] == this.board[r][2])
        || (this.board[0][c] == this.board[1][c] && this.board[1][c] == this.board[2][c])
        || (this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]
            && this.board[1][1] != null)
        || (this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0]
            && this.board[1][1] != null)) {
      this.winner = this.board[r][c];
    }
  }

  @Override
  public Player getTurn() {
    int xTotal = 0;
    int oTotal = 0;

    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (this.getMarkAt(row, col) == Player.X) {
          xTotal++;
        } else if (this.getMarkAt(row, col) == Player.O) {
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
    int spaceFilled = Arrays.stream(this.board)
        .map(row -> Arrays.stream(row).map(p -> p == null ? 0 : 1).reduce(0, (a, b) -> a + b))
        .reduce(0, (a, b) -> a + b);
    return (spaceFilled >= 9) || this.getWinner() != null;
  }

  @Override
  public Player getWinner() {
    return this.winner;
  }

  @Override
  public Player[][] getBoard() {

//    return Arrays.stream(this.board).map(row -> row.clone()).toArray(b -> board.clone());

    Player[][] bd = new Player[3][3];
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        bd[row][col] = this.board[row][col];
      }
    }
    return bd;
  }

  @Override
  public Player getMarkAt(int r, int c) throws IllegalArgumentException {
    if (r < 0 || c < 0 || r > 2 || c > 2) {
      throw new IllegalArgumentException("Cannot get a mark that is off the board");
    }
    return this.board[r][c];
  }
}
