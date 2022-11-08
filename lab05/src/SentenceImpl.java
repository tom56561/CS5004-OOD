import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * SentenceImpl represents Sentence implement with linked list.
 * 
 * @author eddie
 *
 */
public class SentenceImpl implements Sentence {

  private List<SentenceElement> sentence;

  /**
   * A SentenceImpl object with new terms.
   */
  public SentenceImpl() {
    this.sentence = new LinkedList<SentenceElement>();
  }

  /**
   * Make a new SentenceImpl with given sentence.
   * 
   * @param sentence the sentence as a SentenceElement
   */
  public SentenceImpl(List<SentenceElement> sentence) {
    this.sentence = sentence;
  }

  @Override
  public int getNumberOfWords() {

    return (int) this.sentence.stream().filter(element -> element.isWord()).count();

//    int total = 0;
//    for (int item = 0; item < sentence.size(); item++) {
//      if (sentence.get(item) instanceof WordElement) {
//        total++;
//      }
//    }
//    return total;

  }

  @Override
  public String longestWord() {

    return this.sentence.stream().filter(element -> element.isWord())
        .map(element -> element.toString().trim())
        .reduce("", (a, b) -> a.length() >= b.length() ? a : b);

//    int maxLength = this.sentence.stream().filter(element -> element.isWord())
//        .mapToInt(element -> element.toString().length()).reduce(0, (a, b) -> a > b ? a : b);
//    
//    return this.sentence.stream()
//        .filter(element -> element.isWord() && element.toString().length() == maxLength).findFirst()
//        .get().toString();

  }

  @Override
  public String toString() {
    String out = this.sentence.stream().map(element -> element.toString())
        .reduce("", (a, s) -> a + s).trim();

    if (this.sentence.get(this.sentence.size() - 1).isWord()) {
      return out += ".";
    }
    return out;
  }

  @Override
  public Sentence clone() {
//    return new SentenceImpl(this.sentence);

    return new SentenceImpl(this.sentence.stream().map(element -> element.duplicate())
        .collect(Collectors.toCollection(LinkedList::new)));

  }

  @Override
  public Sentence merger(Sentence other) {
    Sentence mergedSentence = this.clone();
    if (other instanceof SentenceImpl) {
      ((SentenceImpl) other).sentence.stream()
          .forEach(element -> mergedSentence.addElement(element.duplicate()));
      return mergedSentence;
    }
    return null;
  }

  @Override
  public int getNumberOfPunctuation() {
    return (int) this.sentence.stream().filter(element -> !(element.isWord())).count();

  }

  @Override
  public int getNumberOfZ() {
    return (int) this.sentence.stream().filter(element -> element.containsZ()).count();
  }

  @Override
  public Sentence tranlateToPigLatin() {
    return new SentenceImpl(this.sentence.stream().map(element -> element.tranlateToPigLatin())
        .collect(Collectors.toCollection(LinkedList::new)));
  }

  @Override
  public void addElement(SentenceElement element) {
    this.sentence.add(element);
  }

  @Override
  public int genericGetNumberOf(Predicate<SentenceElement> p) {
    return (int) this.sentence.stream().filter(p).count();
  }

}
