
public class PunctuationNode implements Sentence {

  private String punctuation;
  private Sentence rest;

  public PunctuationNode(String punctuation, Sentence rest) {
    this.punctuation = punctuation;
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
