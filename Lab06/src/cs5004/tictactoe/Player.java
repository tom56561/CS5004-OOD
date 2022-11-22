package cs5004.tictactoe;

/**
 * Enum include X and O.
 * 
 * @author eddie
 *
 */
public enum Player {
  X, O;

  @Override
  public String toString() {
    return this.name();
  }
}
