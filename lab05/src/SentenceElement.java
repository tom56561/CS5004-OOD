
public interface SentenceElement {

  boolean isWord();
  
  SentenceElement duplicate();
  
  /**
   * Check if this element
   * @return
   */
  boolean containsZ();
  
  /**
   * Tr
   * @return
   */
  SentenceElement tranlateToPigLatin();
}
