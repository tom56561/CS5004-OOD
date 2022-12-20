/**
 * Knight represents a Knight chess piece.
 * 
 * @author eddie
 *
 */
public class Knight extends AbstractPiece {
  /**
   * Create a new Knight given an input row, col, and color.
   * 
   * @param color the color of chess piece
   * @param row   the current row on the board
   * @param col   the current col on the board
   * @throws IllegalArgumentException if row or col below zero
   */
  public Knight(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    if (!this.isInBoard(row, col)) {
      throw new IllegalArgumentException("The given cell can not out of the board");
    }
    if (this.isSamePlace(row, col)) {
      return false;
    }

    int rowMove = Math.abs(this.getRow() - row);
    int colMove = Math.abs(this.getColumn() - col);
    return (rowMove == 1 && colMove == 2 || rowMove == 2 && colMove == 1);
  }

  @Override
  public boolean canKill(ChessPiece piece) throws IllegalArgumentException {
    int row = piece.getRow();
    int col = piece.getColumn();
    if (this.isSamePlace(row, col)) {
      throw new IllegalArgumentException("Can not kill yourself");
    }
    int rowMove = Math.abs(this.getRow() - row);
    int colMove = Math.abs(this.getColumn() - col);
    if (this.isOppositeColor(piece.getColor())) {
      return (rowMove == 1 && colMove == 2 || rowMove == 2 && colMove == 1);
    }
    return false;
  }

}
