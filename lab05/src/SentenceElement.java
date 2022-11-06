
public interface SentenceElement {

  boolean isWord();

  /**
   * Make an exact copy of this SentenceElement.
   * 
   * @return the cloned sentence element
   */
  SentenceElement duplicate();

  /**
   * Check if this is a word element and contains the letter Z.
   * 
   * @return
   */
  boolean containsZ();

  /**
   * Tr
   * 
   * @return
   */
  SentenceElement tranlateToPigLatin();
}
