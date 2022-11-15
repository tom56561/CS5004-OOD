package cs5004.marblesolitaire.model;

/**
 * MarbleSolitaireModelImpl represents a marble solitaire mode implement.
 * 
 * @author eddie
 *
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  private int armThickness;
  private int sRow;
  private int sCol;
  private GameState[][] board;

  /*
   * The first constructor take no parameters
   */
  public MarbleSolitaireModelImpl() {
    this.armThickness = 3;
    this.sRow = 3;
    this.sCol = 3;
    this.initializeBoard();
  }

  /**
   * Second constructor take two parameters: sRow and sCol.
   * 
   * @param sRow the row of the center postion
   * @param sCol the col of the center postion
   * @throws IllegalArgumentException If this specified position is invalid
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    if ((sRow < 2 || sRow > 4) && (sCol < 2 || sCol > 4)) {
      throw new IllegalArgumentException(
          String.format("Invalid empty cell position ($d, $d)", sRow, sCol));
    }
    this.armThickness = 3;
    this.sRow = sRow;
    this.sCol = sCol;
    this.initializeBoard();
  }

  /**
   * Third constructor take the arm thickness.
   * 
   * @param armThickness the armThickness of the board
   * @throws IllegalArgumentException if the arm thickness is not a positive odd
   *                                  number that is at least 3
   */
  public MarbleSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
    if (armThickness % 2 == 0 || armThickness < 3) {
      throw new IllegalArgumentException("armThickness argument is invalid");
    }
    this.armThickness = armThickness;
    this.sRow = 3 * (armThickness / 2);
    this.sCol = 3 * (armThickness / 2);
    this.initializeBoard();
  }

  /**
   * Fourth constructor should take the arm thickness, row and column of the empty
   * slot in that order.
   * 
   * @param armThickness the armThickness of the board
   * @param sRow         the row of the center postion
   * @param sCol         the col of the center postion
   * @throws IllegalArgumentException if the arm thickness is not a positive odd
   *                                  number of at least 3, or the empty cell
   *                                  position is invalid
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol)
      throws IllegalArgumentException {
    if (sRow < armThickness - 1 && sCol < armThickness - 1
        || sRow < armThickness - 1 && sCol > (armThickness * 2) - 2
        || sRow > (armThickness * 2) - 2 && sCol < armThickness - 1
        || sRow > (armThickness * 2) - 2 && sCol > (armThickness * 2) - 2) {
      throw new IllegalArgumentException(
          String.format("Invalid empty cell position ($d, $d)", sRow, sCol));
    }

    if (armThickness % 2 == 0 || armThickness < 3) {
      throw new IllegalArgumentException("armThickness argument is invalid");
    }
    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;
    this.initializeBoard();
  }

  /**
   * Initialize Board based on armThickness, sRow, sCol.
   */
  protected void initializeBoard() {
    int length = this.armThickness * 3 - 2;
    this.board = new GameState[length][length];
    for (int row = 0; row < length; row++) {
      for (int col = 0; col < length; col++) {
        if (row >= armThickness * 2 - 1 && col < armThickness - 1
            || row >= armThickness * 2 - 1 && col >= armThickness * 2 - 1
            || row < armThickness - 1 && col < armThickness - 1
            || row < armThickness - 1 && col >= armThickness * 2 - 1) {
          this.board[row][col] = GameState.Outside;
        } else if (row == this.sRow && col == this.sCol) {
          this.board[row][col] = GameState.Empty;
        } else {
          this.board[row][col] = GameState.O;
        }
      }
    }
  }

  /**
   * Return True if the move is valid, otherwise.
   * 
   * @param fromRow    the row position to be moved from
   * @param fromColumn the column position to be moved from
   * @param toRowthe   row position to be moved to
   * @param toColumn   the column position to be moved to
   * @return True if the move is valid, otherwise
   */
  protected boolean isValidMove(int fromRow, int fromColumn, int toRow, int toColumn) {
    int length = this.armThickness * 3 - 2;
    if (fromRow >= 0 && toRow >= 0 && fromColumn >= 0 && toColumn >= 0 && fromRow < length
        && fromColumn < length && toRow < length && toColumn < length) {
      GameState fromSpot = board[fromRow][fromColumn];
      GameState toSpot = board[toRow][toColumn];
      GameState midSpot = board[(fromRow + toRow) / 2][(fromColumn + toColumn) / 2];
      return (fromSpot == GameState.O && midSpot == GameState.O && toSpot == GameState.Empty)
          && ((Math.abs(fromRow - toRow) == 2 && fromColumn - toColumn == 0)
              || (Math.abs(fromColumn - toColumn) == 2 && fromRow - toRow == 0));
    }
    return false;
  }

  /**
   * Return True if game if not over, otherwise.
   * 
   * @param row the row of the center postion
   * @param col the col of the center postion
   * @return true if game if not over, otherwise
   */
  protected boolean notGameOver(int row, int col) {
    int length = this.armThickness * 3 - 2;
    return row < (length - 1) && this.isValidMove(row, col, row + 2, col)
        || row > 1 && this.isValidMove(row, col, row - 2, col)
        || col < (length - 1) && this.isValidMove(row, col, row, col + 2)
        || col > 1 && this.isValidMove(row, col, row, col - 2);
  }

  @Override
  public void move(int fromRow, int fromColumn, int toRow, int toColumn)
      throws IllegalArgumentException {
    if (!this.isValidMove(fromRow, fromColumn, toRow, toColumn)) {
      throw new IllegalArgumentException("Invalid move.");
    }
    board[fromRow][fromColumn] = GameState.Empty;
    board[toRow][toColumn] = GameState.O;
    board[(fromRow + toRow) / 2][(fromColumn + toColumn) / 2] = GameState.Empty;

  }

  @Override
  public String getGameState() {
    StringBuilder result = new StringBuilder();
    int length = this.armThickness * 3 - 2;
    for (int row = 0; row < length; row++) {
      for (int col = 0; col < length; col++) {
        GameState current = this.board[row][col];
        if (current == GameState.Outside && col > (2 * length / 3 - 1)) {
          continue;
        }
        if (col > 0 && col < length) {
          result.append(" ");
        }
        result.append(current);
      }
      if (row < length - 1) {
        result.append("\n");
      }
    }

    return result.toString();
  }

  @Override
  public boolean isGameOver() {
    int length = this.armThickness * 3 - 2;
    for (int row = 0; row < length; row++) {
      for (int col = 0; col < length; col++) {
        GameState current = this.board[row][col];
        if (current == GameState.O && this.notGameOver(row, col)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getScore() {
    int score = 0;
    int length = this.armThickness * 3 - 2;
    for (int row = 0; row < length; row++) {
      for (int col = 0; col < length; col++) {
        GameState current = this.board[row][col];
        if (current == GameState.O) {
          score++;
        }
      }
    }
    return score;
  }

}
