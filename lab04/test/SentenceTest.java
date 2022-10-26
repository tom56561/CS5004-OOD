import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for Sentence all method.
 */
public class SentenceTest {

  /**
   * Tests if getNumberOfWords properly returns the number of words.
   */
  @Test
  public void testGetNumberOfWords() {
    Sentence s;
    s = new EmptyNode();
    assertEquals(0, s.getNumberOfWords());

    s = new PunctuationNode("!", s);
    assertEquals(0, s.getNumberOfWords());

    s = new WordNode("Morning", s);
    assertEquals(1, s.getNumberOfWords());

    s = new WordNode("Good", s);
    assertEquals(2, s.getNumberOfWords());

    s = new PunctuationNode(",", s);
    assertEquals(2, s.getNumberOfWords());

    s = new WordNode("Hello", s);
    assertEquals(3, s.getNumberOfWords());
  }

  /**
   * Tests if longestWord properly returns the longest word.
   */
  @Test
  public void testLongestWord() {
    Sentence s;
    s = new EmptyNode();
    assertEquals("", s.longestWord());
    s = new PunctuationNode("!", s);
    assertEquals("", s.longestWord());
    s = new WordNode("Morning", s);
    assertEquals("Morning", s.longestWord());
    s = new WordNode("Good", s);
    assertEquals("Morning", s.longestWord());
    s = new PunctuationNode(",", s);
    assertEquals("Morning", s.longestWord());
    s = new WordNode("Hello", s);
    assertEquals("Morning", s.longestWord());

    s = new EmptyNode();
    s = new WordNode("Day", s);
    assertEquals("Day", s.longestWord());
    s = new WordNode("Good", s);
    assertEquals("Good", s.longestWord());
    s = new WordNode("a", s);
    assertEquals("Good", s.longestWord());
    s = new WordNode("is", s);
    assertEquals("Good", s.longestWord());
    s = new WordNode("Tomorrow", s);
    assertEquals("Tomorrow", s.longestWord());

    s = new EmptyNode();
    s = new WordNode("Day", s);
    assertEquals("Day", s.longestWord());
    s = new WordNode("Bad", s);
    assertEquals("Bad", s.longestWord());
  }

  /**
   * Tests ToString method.
   */
  @Test
  public void testToString() {
    Sentence s;
    s = new EmptyNode();
    assertEquals("", s.toString());
    s = new PunctuationNode("!", s);
    assertEquals("!", s.toString());
    s = new WordNode("Morning", s);
    assertEquals("Morning!", s.toString());
    s = new WordNode("Good", s);
    assertEquals("Good Morning!", s.toString());
    s = new PunctuationNode(",", s);
    assertEquals(", Good Morning!", s.toString());
    s = new WordNode("Hello", s);
    assertEquals("Hello, Good Morning!", s.toString());

    s = new EmptyNode();
    s = new WordNode("Day", s);
    assertEquals("Day", s.toString());
    s = new PunctuationNode(",", s);
    assertEquals(", Day", s.toString());
    s = new WordNode("Good", s);
    assertEquals("Good, Day", s.toString());

  }

  /**
   * Tests if clone properly clone a new object.
   */
  @Test
  public void testClone() {
    Sentence s;
    s = new EmptyNode();
    assertEquals(s, s);
    assertNotEquals(s, s.clone());
    assertEquals(s.toString(), s.clone().toString());

    s = new PunctuationNode("!", s);
    assertNotEquals(s, s.clone());
    assertEquals(s.toString(), s.clone().toString());

    s = new WordNode("Day", s);
    assertNotEquals(s, s.clone());
    assertEquals(s.toString(), s.clone().toString());

    s = new WordNode("Good", s);
    assertNotEquals(s, s.clone());
    assertEquals(s.toString(), s.clone().toString());

  }

  /**
   * Tests if merge properly merge two object.
   */
  @Test
  public void testMerge() {
    Sentence s = new EmptyNode();
    s = new PunctuationNode("!", s);
    s = new WordNode("Day", s);
    s = new WordNode("Good", s);

    Sentence o = new EmptyNode();
    o = new PunctuationNode(".", o);
    o = new WordNode("Tomorrow", o);
    o = new WordNode("You", o);
    o = new WordNode("See", o);

    Sentence m;
    m = s.merger(o);
    assertEquals("Good Day!", s.toString());
    assertEquals("See You Tomorrow.", o.toString());
    assertEquals("Good Day! See You Tomorrow.", m.toString());

  }

}
