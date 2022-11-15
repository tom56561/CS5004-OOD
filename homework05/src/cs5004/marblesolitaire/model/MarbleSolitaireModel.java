package cs5004.marblesolitaire.model;

/**
 * The MarbleSolitaireModel interface defines all the supported operations for
 * each MarbleSolitaireModel.
 * 
 * @author eddie
 *
 */
public interface MarbleSolitaireModel {

  /**
   * Specifically it will move a marble from the position (fromRow, fromColumn) to
   * the position (toRow, toColumn).
   * 
   * @param fromRow    the row position to be moved from
   * @param fromColumn the column position to be moved from
   * @param toRowthe   row position to be moved to
   * @param toColumn   the column position to be moved to
   * @throws IllegalArgumentException
   */
  void move(int fromRow, int fromColumn, int toRow, int toColumn) throws IllegalArgumentException;

  /**
   * Returns the current state of the game as a String
   * 
   * @return the current state of the game as a String.
   */
  String getGameState();

  /**
   * Returns true if the game is over, and false.
   * 
   * @return true if the game is over, and false
   */
  boolean isGameOver();

  /**
   * Returns the current score in the game.
   * 
   * @return the current score in the game
   */
  int getScore();
}
