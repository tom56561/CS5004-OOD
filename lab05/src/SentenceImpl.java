import java.util.LinkedList;
import java.util.List;

public class SentenceImpl implements Sentence {

  private List<SentenceElement> sentence;

  public SentenceImpl() {
    sentence = new LinkedList<SentenceElement>();
  }

  @Override
  public int getNumberOfWords() {

//    int total = 0;
//    for (int item = 0; item < sentence.size(); item++) {
//      if (sentence.get(item) instanceof WordElement) {
//        total++;
//      }
//    }
//    return total;
    
    return (int) this.sentence.stream().filter(element -> element.isWord()).count();
  }

  @Override
  public String longestWord() {

    return this.sentence.stream().filter(element -> element.isWord())
        .map(element -> element.toString().trim())
        .reduce("", (a, b) -> a.length() >= b.length() ? a : b);

//    int maxLength = this.sentence.stream.filter(element -> element.isWord())
//        .mapToInt(element -> element.toString().length()).reduce(0, (a, b) -> a > b ? a : b);
//
//    return this.sentence.stream()
//        .filter(element -> element.isWord() && element.toString().lenght() == maxLength).findFirst()
//        .get().toString();
  }

  @Override
  public String toString() {
    return this.sentence.stream().map(element -> element.toString()).reduce("", (a, s) -> a + s)
        .trim();
  }

  @Override
  public Sentence clone() {
    return null;
  }

  @Override
  public Sentence merger(Sentence other) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getNumberOfZ() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Sentence tranlateToPigLatin() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void addElement(SentenceElement element) {
    this.sentence.add(element);
  }

}
