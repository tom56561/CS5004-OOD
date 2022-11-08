/**
 * The SentenceElement interface defines all the supported operations for a
 * SentenceElement. A Sentence is a list of different elements, which can
 * include Words and Punctuation.
 * 
 * @author eddie
 *
 */
public interface SentenceElement {

  /**
   * Returns true if and only if this element is word.
   * 
   * @return True if this is a word, false otherwise
   */
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
   * @return true if and only if this element contains a Z
   */
  boolean containsZ();

  /**
   * Tranlated word by following pig latin rule.
   * 
   * @return new word with pig latin rule
   */
  SentenceElement tranlateToPigLatin();
}
