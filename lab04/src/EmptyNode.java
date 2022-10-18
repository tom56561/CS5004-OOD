
public class EmptyNode implements Sentence {

  @Override
  public int getNumberOfWords() {
    return 0;
  }

  @Override
  public String longestWord() {
    return "";
  }

  @Override
  public Sentence clone() {
    return new EmptyNode();
  }

  @Override
  public Sentence merger(Sentence other) {
    return other.clone();
  }

  @Override
  public String toString() {
    return "";
  }
}
