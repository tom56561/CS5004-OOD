
public class WordNode implements Sentence {
  private String word;
  private Sentence rest;

  public WordNode(String word, Sentence rest) {
    this.word = word;
    this.rest = rest;
  }

  @Override
  public int getNumberOfWords() { 
    return 1 + this.rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {
    String biggest = this.rest.longestWord();
    if (biggest.length() > this.word.length()) {
      return biggest;
    }
    return this.word;
  }

  @Override
  public Sentence clone() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Sentence merger(Sentence other) {
    // TODO Auto-generated method stub
    return null;
  }

}
