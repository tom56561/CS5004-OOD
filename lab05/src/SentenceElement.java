
public interface SentenceElement {

  boolean isWord();

  /**
   * Make an exact copy of this SentenceElement.
   * 
   * @return the cloned sentence element
   */
  SentenceElement duplicate();

  /**
   * Check if this element
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
