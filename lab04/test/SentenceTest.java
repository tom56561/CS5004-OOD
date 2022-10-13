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

    s = new WordNode("Morning", s);
    assertEquals(1, s.getNumberOfWords());

    s = new WordNode("Good", s);
    assertEquals(2, s.getNumberOfWords());

    s = new PunctuationNode(",", s);
    assertEquals(2, s.getNumberOfWords());

    s = new WordNode("Hello", s);
    assertEquals(3, s.getNumberOfWords());
  }

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

}
