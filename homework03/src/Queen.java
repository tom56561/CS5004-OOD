
public class Queen extends AbstractPiece {

  public Queen(int row, int col, Color color) throws IllegalArgumentException {
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
