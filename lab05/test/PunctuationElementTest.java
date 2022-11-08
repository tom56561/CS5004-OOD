import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 * Test PunctuationElementTest method.
 * 
 * @author eddie
 *
 */
public class PunctuationElementTest {

  /**
   * Test isWord method work well.
   */
  @Test
  public void testIsword() {
    SentenceElement w = new PunctuationElement("!");
    assertFalse(w.isWord());

    w = new PunctuationElement(",");
    assertFalse(w.isWord());

    w = new PunctuationElement(".");
    assertFalse(w.isWord());

  }

  /**
   * Test duplicate method work well.
   */
  @Test
  public void testDuplicate() {
    SentenceElement s = new PunctuationElement("!");
    assertNotEquals(s, s.duplicate());
    assertEquals(s.toString(), s.duplicate().toString());
  }

}
