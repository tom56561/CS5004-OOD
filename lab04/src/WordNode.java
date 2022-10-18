
public class WordNode implements Sentence {
  private String word;
  private Sentence rest;

  public WordNode(String word, Sentence rest) {
    this.word = word;
    this.rest = rest;
  }

  @Override
  public int getNumberOfWords() {
    return 1 + this.rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {
    String biggest = this.rest.longestWord();
    if (biggest.length() > this.word.length()) {
      return biggest;
    }
    return this.word;
  }

  @Override
  public Sentence clone() {
    return new WordNode(this.word, this.rest.clone());

  }

  @Override
  public Sentence merger(Sentence other) {
    return new WordNode(this.word, this.rest.merger(other));
  }

  /**
   * Return the entire sentence as a String. There will be a space between two
   * word nodes. There will not be a space between a word node and the
   * punctiuation that follows it. There will be a space bewtween a punctuation
   * and the word that follows it.
   */
  @Override
  public String toString() {
    if (this.rest instanceof WordNode) {
      return this.word + " " + this.rest.toString();
    }
    return this.word + this.rest.toString();
  }
}
