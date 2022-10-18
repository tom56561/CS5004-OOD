/**
 * This class represents AbstractPiece. A AbstractTemperature has a color, x,
 * and y.
 */
public abstract class AbstractPiece implements ChessPiece {

  private final Color color;
  private int row;
  private int col;

  /**
   * Create a new AbstractPiece given an input color, x, and y.
   * 
   * @param color the color of chess piece
   * @param row   the current row on the board
   * @param col   the current col on the board
   * @throws IllegalArgumentException if row or col below zero
   */
  public AbstractPiece(int row, int col, Color color) throws IllegalArgumentException {
    if (row < 0 || col < 0 || row > 7 || col > 7) {
      throw new IllegalArgumentException("x or y can not below zero");
    }
    this.color = color;
    this.row = row;
    this.col = col;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.col;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public boolean canMove(int row, int col) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) throws IllegalArgumentException {
    if (this.isSamePlace(piece.getRow(), piece.getColumn())) {
      throw new IllegalArgumentException("Can not kill yourself");
    }
    return false;
  }

  /**
   * Return true if color is opposite color.
   * 
   * @param color the color of chess piece
   * @return true if color is opposite color
   */
  public boolean isOppositeColor(Color color) {
    return this.color != color;
  }

  /**
   * Return true if row and col inside the borad.
   * 
   * @param row the given row
   * @param col the given col
   * @return true if row and col inside the borad
   */
  public boolean isInBoard(int row, int col) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      return false;
    }
    return true;
  }

  /**
   * Return if given row and col is same as piece itself.
   * 
   * @param row the given row
   * @param col the given col
   * @return if given row and col is same as piece itself
   */
  public boolean isSamePlace(int row, int col) {
    if (this.row == row && this.col == col) {
      return true;
    }
    return false;
  }

  /**
   * Return whether a piece can move in a diagonal line by given row and col.
   * 
   * @param row the given row
   * @param col the given col
   * @return whether a piece can move in a diagonal line by given row and col
   */
  public boolean isDiagonal(int row, int col) {
    if (this.row == row || this.col == col) {
      return false;
    }

    return Math.abs(this.row - row) == Math.abs(this.col - col);
  }

}
