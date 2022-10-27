
public class WordElement implements SentenceElement {

  private String word;
  
  public WordElement(String word) {
    this.word = word;
  }

  @Override
  public boolean isWord() {
    // TODO Auto-generated method stub
    return true;
  }
}
