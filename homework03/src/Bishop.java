/**
 * Bishop represents a chess piece.
 * 
 * @author eddie
 *
 */
public class Bishop extends AbstractPiece {

  /**
   * Create a new Bishop given an input color, x, and y.
   * 
   * @param color the color of chess piece
   * @param x     the current row on the board
   * @param y     the current col on the board
   * @throws IllegalArgumentException if x or y below zero
   */
  public Bishop(ChessPiece.Color color, int row, int col) throws IllegalArgumentException {
    super(color, row, col);
  }

  @Override
  public boolean canMove(int row, int col) {
    return this.isDiagonal(row, col);
  }

  @Override
  public boolean canKill(ChessPiece piece) {

    return this.isDiagonal(piece.getRow(), piece.getColumn());
  }

}
