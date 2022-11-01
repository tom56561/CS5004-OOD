
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
  
  @Override
  public SentenceElement duplicate() {
    return new PunctuationElement(this.punctuation);
  }  
  
  @Override
  public String toString() {
    return this.punctuation;
  }

  @Override
  public boolean containsZ() {
    return false;
  }

  @Override
  public SentenceElement tranlateToPigLatin() {
    return this.duplicate();
  }

}
