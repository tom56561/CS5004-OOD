package cs5004.marblesolitaire.model;

public enum GameState {
  O("O"), Empty("_"), Outside(" ");

  private String state;
  
  GameState(String state){
    this.state = state;
  }
  @Override
  public String toString() {
    return this.state;
  }
}
