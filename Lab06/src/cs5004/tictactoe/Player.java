package cs5004.tictactoe;

public enum Player {
  X, O;

  @Override
  public String toString() {
    return this.name();
  }
}
