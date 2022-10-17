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
  public Bishop(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
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
