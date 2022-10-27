
public interface Sentence {

  /**
   * Return the number of words in a sentence. The punctuation does not count as a
   * word.
   * 
   * @return the number of words in a sentence
   */
  int getNumberOfWords();

  /**
   * Returns the longest word in a sentence. Only the word is returned, no
   * punctuation is included. If this sentence contains no words, an empty string
   * is returned. If there are mutilple words of the same length, of that set of
   * words, one close to the beginning will return.
   * 
   * @return the longest word in a sentence
   */
  String longestWord();

  /**
   * Duplicates this sentence. The new sentence has the same data as the original
   * sentence, in the same order, but is not linked to the original sentence in
   * any way
   * 
   * @return a copy of this sentence
   */
  Sentence clone();

  /**
   * Merges two sentences into one. All punctuation is preserved. The two original
   * sentences should be not affected by the merge.
   * 
   * @param other another sentence
   * @return the two sentences merged
   */
  Sentence merger(Sentence other);

  /**
   * Returns the total number of words containing one or more of letter Z. If a
   * word contains multiole Zs it still only counts as one word.
   * 
   * @return the number of words with a Z
   */
  int getNumberOfZ();

  /**
   * Translates the sentence to pig Latin.
   * 
   * @return
   */
  Sentence tranlateToPigLatin();

  /**
   * Add an element to the next spot in the sentence.
   * 
   * @param element any SentenceElement
   */
  void addElement(SentenceElement element);
}
