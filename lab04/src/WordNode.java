
public class WordNode implements Sentence {
  private String word;
  private Sentence rest;
  public WordNode(String word, Sentence rest) {
    this.word = word;
    this.rest = rest;
  }

  @Override
  public int getNumberOfWords() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String longestWord() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Sentence clone() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Sentence merger(Sentence other) {
    // TODO Auto-generated method stub
    return null;
  }

}
