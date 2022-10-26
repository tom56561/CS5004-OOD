
public class WordElement implements SentenceElement {

  public WordElement() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public boolean isWord() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public SentenceElement duplicate() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String toString() {
    return " " + this.Word;
  }
}
