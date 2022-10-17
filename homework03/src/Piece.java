
public abstract class Piece implements ChessPiece {
  
  private final ChessPiece.Color color;
  private int x;
  private int y;
  
  public Piece(ChessPiece.Color color, int x, int y) throws IllegalArgumentException {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("x or y can not below zero");
    }
    this.color = color;
    this.x = x;
    this.y = y;
  }
  

  @Override
  public int getRow() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getColumn() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public ChessPiece.Color getColor() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean canMove(int row, int col) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    // TODO Auto-generated method stub
    return false;
  }

}
