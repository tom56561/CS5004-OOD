/**
 * The Sentence interface defines all the supported operations for each chess
 * piece.
 * 
 * @author eddie
 *
 */
public interface ChessPiece {

  /**
   * Colors that can be used
   */
  enum Color {
    BLACK, WHITE
  }

  /**
   * Return its current row on the chess board.
   * 
   * @return its current row on the chess board
   */
  int getRow();

  /**
   * Return its current column on the chess board.
   * 
   * @return its current column on the chess board
   */
  int getColumn();

  /**
   * Return its color.
   * 
   * @return its color
   */
  Color getColor();

  /**
   * Return if it can move to a given cell as a boolean.
   * 
   * @param row the row position on the board
   * @param col the col position on the board
   * @return true if it can move to a given cell
   */
  boolean canMove(int row, int col);

  /**
   * Return if it can kill a provided piece starting from where it currently is.
   * 
   * @param piece the piece can be killed
   * @return true if it can kill the piece
   */
  boolean canKill(ChessPiece piece);

}
