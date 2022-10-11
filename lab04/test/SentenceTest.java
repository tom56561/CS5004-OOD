import static org.junit.Assert.*;

import org.junit.Test;

public class SentenceTest {

  @Test
  public void testGetNumberOfWords() {
    Sentence s;
    s = new EmptyNode();
    assertEquals(0, s.getNumberOfWords());
    
    s = new PunctuationNode("!", s);
    assertEquals(0, s.getNumberOfWords());

    s = new WordNode("Moring", s);
    assertEquals(1, s.getNumberOfWords());
    
    s = new WordNode("Good", s);
    assertEquals(2, s.getNumberOfWords());

    s = new PunctuationNode(",", s);
    assertEquals(2, s.getNumberOfWords());
    
    s = new WordNode("Hello", s);
    assertEquals(3, s.getNumberOfWords());



  }

}
