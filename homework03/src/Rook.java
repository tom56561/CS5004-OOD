/**
 * Rook represents a Rook chess piece.
 * 
 * @author eddie
 *
 */
public class Rook extends AbstractPiece {
  /**
   * Create a new Rook given an input row, col, and color.
   * 
   * @param color the color of chess piece
   * @param row   the current row on the board
   * @param col   the current col on the board
   * @throws IllegalArgumentException if row or col below zero
   */
  public Rook(int row, int col, Color color) throws IllegalArgumentException {
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

    return this.isHorizontalOrVertical(row, col);
  }

  @Override
  public boolean canKill(ChessPiece piece) throws IllegalArgumentException {
    int row = piece.getRow();
    int col = piece.getColumn();
    if (this.isSamePlace(row, col)) {
      throw new IllegalArgumentException("Can not kill yourself");
    }

    if (this.isOppositeColor(piece.getColor())) {
      return this.isHorizontalOrVertical(row, col);
    }
    return false;
  }

}
