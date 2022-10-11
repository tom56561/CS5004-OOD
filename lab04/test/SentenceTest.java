import static org.junit.Assert.*;

import org.junit.Test;

public class SentenceTest {

  @Test
  public void testGetNumberOfWords() {
    Sentence s;
    s = new EmptyNode();
    assertEquals(0, s.getNumberOfWords());
    
  }

}
