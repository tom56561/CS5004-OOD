package cs5004.marblesolitaire.model;
/**
 * The MarbleSolitaireModel interface defines all the supported operations for
 * each MarbleSolitaireModel.
 * 
 * @author eddie
 *
 */
public interface MarbleSolitaireModel {

  void move(int fromRow, int fromColumn, int toRow, int toColumn) throws IllegalArgumentException;

  String getGameState();

  /**
   * Return whether the game is over. The game is over when user can not move.
   *
   * @return true if the game is over, false otherwise
   */
  boolean isGameOver();

  int getScore();
}
