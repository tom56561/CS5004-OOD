import static org.junit.Assert.*;

import org.junit.Test;

public class WordElementTest {

  @Test
  public void test() {
    WordElement w = new WordElement("Hello");
    assertTrue(w.isWord());
    
    w = new WordElement("GoodBye");
    assertTrue(w.isWord());

    
    w = new WordElement(".");
    assertTrue(w.isWord());

  }

}
