import java.util.function.Predicate;

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
   * Return the number of words in a sentence. The punctuation does not count as a
   * word.
   * 
   * @return the number of words in a sentence
   */
  int getNumberOfWords();

  /**
   * Returns the longest word in a sentence. Only the word is returned, no
   * punctuation is included. If this sentence contains no words, an empty string
   * is returned. If there are multiple words of the same length, of that set of
   * words, one close to the beginning will return.
   * 
   * @return the longest word in a sentence
   */
  String longestWord();

  /**
   * Duplicates this sentence. The new sentence has the same data as the original
   * sentence, in the same order, but is not linked to the original sentence in
   * any way.
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
   * Counts the number of punctuation and returns that value.
   * 
   * @return the number of punctuation
   */
  int getNumberOfPunctuation();

  /**
   * Returns the total number of words containing one or more of letter Z. If a
   * word contains multiple Zs it still only counts as one word.
   * 
   * @return the number of words with a Z
   */
  int getNumberOfZ();

  /**
   * Check each part of the sentence and count the number of parts for which this
   * predicate is true.
   * 
   * @param p the condition of sentenceElement
   * @return the number of element for certain condition
   */
  int genericGetNumberOf(Predicate<SentenceElement> p);

  /**
   * Return this sentence but converted to Pig Latin. This means each word is
   * changed. Words that begin with a consonant have the first consonant moved to
   * the end, and "ay" is added to the end. Words that begin with a vowel have
   * "way" added to the end.
   * 
   * @return the sentence translated to pig latin
   */
  Sentence tranlateToPigLatin();

  /**
   * Add an element to the next spot in the sentence.
   * 
   * @param element any SentenceElement
   */
  void addElement(SentenceElement element);
}
