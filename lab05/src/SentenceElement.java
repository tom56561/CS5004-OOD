
public interface SentenceElement {

  /**
   * Returns true if and only if this element is word.
   * @return True is this is a word, false otherwise
   */
  boolean isWord();
  
  /**
   * Creates a copy of this SentenceElement
   * @return
   */
  SentenceElement duplicate();
}
