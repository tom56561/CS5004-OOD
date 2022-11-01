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
  
  @Test
  public void testDuplicate() {
    SentenceElement s = new WordElement("Hello");
    assertNotEquals(s, s.duplicate());
    assertEquals(s.toString(), s.duplicate().toString());
  }

}
