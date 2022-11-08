
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test WordElementTest method.
 * 
 * @author eddie
 *
 */
public class WordElementTest {

  /**
   * Test isWord work well.
   */
  @Test
  public void testIsword() {
    WordElement w = new WordElement("Hello");
    assertTrue(w.isWord());

    w = new WordElement("GoodBye");
    assertTrue(w.isWord());

    w = new WordElement(".");
    assertTrue(w.isWord());

  }

  /**
   * Test duplicate method work well.
   */
  @Test
  public void testDuplicate() {
    SentenceElement s = new WordElement("Hello");
    assertNotEquals(s, s.duplicate());
    assertEquals(s.toString(), s.duplicate().toString());
  }

}
