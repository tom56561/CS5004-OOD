/**
 * This class represents AbstractPiece. A AbstractTemperature has a color, x,
 * and y.
 */
public abstract class AbstractPiece implements ChessPiece {

  private final Color color;
  private int row;
  private int col;

  /**
   * Create a new AbstractPiece given an input row, col, and color.
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
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    if (!this.isInBoard(row, col)) {
      throw new IllegalArgumentException("The given cell can not out of the board");
    }
    return !this.isSamePlace(row, col);
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
  protected boolean isOppositeColor(Color color) {
    return this.color != color;
  }

  /**
   * Return true if row and col inside the borad.
   * 
   * @param row the given row
   * @param col the given col
   * @return true if row and col inside the borad
   */
  protected boolean isInBoard(int row, int col) {
    return !(row < 0 || row > 7 || col < 0 || col > 7);
  }

  /**
   * Return if given row and col is same as piece itself.
   * 
   * @param row the given row
   * @param col the given col
   * @return if given row and col is same as piece itself
   */
  protected boolean isSamePlace(int row, int col) {
    return (this.row == row && this.col == col);
  }

  /**
   * Return whether a piece can move in a diagonal line by given row and col.
   * 
   * @param row the given row
   * @param col the given col
   * @return whether a piece can move in a diagonal line by given row and col
   */
  protected boolean isDiagonal(int row, int col) {
    if (this.row == row && this.col == col) {
      return false;
    }

    return Math.abs(this.row - row) == Math.abs(this.col - col);
  }

  protected boolean isHorizontalOrVertical(int row, int col) {
    if (this.row == row && this.col == col) {
      return false;
    }

    return (this.row == row && this.col != col) || (this.col == col && this.row != row);
  }

}
