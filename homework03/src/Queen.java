
public class Queen extends AbstractPiece {

  public Queen(ChessPiece.Color color, int row, int col) throws IllegalArgumentException {
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
