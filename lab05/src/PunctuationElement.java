
public class PunctuationElement implements SentenceElement {

  private String punctuation;
  
  public PunctuationElement(String punctuation) {
    this.punctuation = punctuation;
  }

  @Override
  public boolean isWord() {
    // TODO Auto-generated method stub
    return false;
  }
}
