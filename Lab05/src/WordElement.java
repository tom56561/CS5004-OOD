/**
 * WordElement represents one word per node with word.
 * 
 * @author eddie
 */
public class WordElement implements SentenceElement {

  private String word;

  /**
   * Makes a new WordElement object with the given word.
   * 
   * @param word the word of the node
   */
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
    String newWord;
    if ((this.word.charAt(0) + "").toLowerCase().matches("[aeiouy]")) {
      newWord = this.word + "way";
    } else {
      newWord = this.word.substring(1) + this.word.charAt(0) + "ay";
    }

    return new WordElement(newWord);
  }

}
