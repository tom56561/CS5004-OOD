
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
  
  @Override
  public SentenceElement duplicate() {
    return new WordElement(this.word);
  }

  @Override
  public String toString() {
    return " " + this.word;
  }

  @Override
  public boolean containsZ() {
    return this.word.contains("z");
  }

  @Override
  public SentenceElement tranlateToPigLatin() {
    if ((this.word.charAt(0) + "").toLowerCase().matches("[aeiouy]")) {
      return new WordElement(this.word + "way");
    }
    return new WordElement(this.word.substring(1) + this.word.charAt(0) + "ay");
  }

}
