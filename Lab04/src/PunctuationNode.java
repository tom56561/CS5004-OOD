/**
 * PunctuationNode represents zero or more punctuation marks.
 * 
 * @author eddie
 *
 */
public class PunctuationNode implements Sentence {

  private String punctuation;
  private Sentence rest;

  /**
   * Makes a new PunctuationNode object with the given punctuation and rest.
   * 
   * @param punctuation the punctuation of the node
   * @param rest        the rest of node
   */
  public PunctuationNode(String punctuation, Sentence rest) {
    this.punctuation = punctuation;
    this.rest = rest;

  }

  @Override
  public int getNumberOfWords() {
    return this.rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {
    return this.rest.longestWord();
  }

  @Override
  public Sentence clone() {
    return new PunctuationNode(this.punctuation, this.rest.clone());
  }

  @Override
  public Sentence merger(Sentence other) {
    return new PunctuationNode(this.punctuation, this.rest.merger(other));

  }

  @Override
  public String toString() {
    if (this.rest instanceof PunctuationNode || this.rest instanceof EmptyNode) {
      return this.punctuation + this.rest.toString();
    }
    return this.punctuation + " " + this.rest.toString();

  }
}
