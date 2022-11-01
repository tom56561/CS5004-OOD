import static org.junit.Assert.*;

import org.junit.Test;

public class PunctuationElementTest {

//  @Test
//  public void test() {
//    
//    PunctuationElement p = new PunctuationElement("!");
//    assertTrue()
//  }

  @Test
  public void testDuplicate() {
    SentenceElement s = new PunctuationElement("!");
    assertNotEquals(s, s.duplicate());
    assertEquals(s.toString(), s.duplicate().toString());
  }

}
