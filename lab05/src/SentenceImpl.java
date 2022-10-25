
public class SentenceImpl implements Sentence {

  private List<SentenceElement> sentence;

  public SentenceImpl() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public int getNumberOfWords() {
    return (int) this.sentence.stream().filter(element -> element.isWord()).count();
  }

  @Override
  public String longestWord() {

    return this.sentence.stream().filter(element -> element.isWord())
        .map(element -> element.toString()).reduce("", (a, b) -> a.length() >= b.length() ? a : b);

//    int maxLength = this.sentence.stream.filter(element -> element.isWord())
//        .mapToInt(element -> element.toString().length()).reduce(0, (a, b) -> a > b ? a : b);
//
//    return this.sentence.stream()
//        .filter(element -> element.isWord() && element.toString().lenght() == maxLength).findFirst()
//        .get().toString();
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
    // TODO Auto-generated method stub

  }

}
