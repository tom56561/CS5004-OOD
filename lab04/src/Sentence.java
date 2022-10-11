/**
 * The Sentence interface defines all the supported operations for a Sentence. A
 * Sentence is a list of different elements, which can include Words and
 * Punctuation.
 * 
 * @author eddie
 *
 */
public interface Sentence {

  /**
   * Return the number of words in a sentence.
   * The punctuation does not count as a word.
   * 
   * @return the number of words in a sentence
   */
  int getNumberOfWords();

  /**
   * Returns the longest word in a sentence. 
   * Only the word is returned, no
   * punctuation is included. 
   * If this sentence contains no words, an empty string is returned.
   * 
   * @return the longest word in a sentence
   */
  String longestWord();

  /**
   * Returns a duplicate of a given sentence
   * @return a duplicate of a given sentence
   */
  Sentence clone();
  
  
  /**
   * Merges this Sentence and another Sentence into a single sentence.
   * 
   * @param other Sentence
   * @return
   */
  Sentence merger(Sentence other);
}
