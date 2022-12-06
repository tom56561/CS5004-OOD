package cs5004.tictactoe;

/**
 * An Enum represent X and O.
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
