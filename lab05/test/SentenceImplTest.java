import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SentenceImplTest {
  Sentence S

  @Test
  public void testGetNumberOfWords() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testLongestWord() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuantionElement(","));
    s.addElement(new WordElement("Good"));
    s.addElement(new WordElement("Morning"));
    s.addElement(new PunctuantionElement("!"));
    assertEquals("Morning", s.longestWord());
    
     s = new SentenceImpl();
     s.addElement(new WordElement("How"));
     s.addElement(new WordElement("are"));
     s.addElement(new WordElement("you"));
     s.addElement(new PunctuantionElement("?"));
     assertEquals("How", s.longestWord());

  }
  
  @Test
  public void testClone() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuantionElement(","));
    s.addElement(new WordElement("Good"));
    s.addElement(new WordElement("Morning"));
    s.addElement(new PunctuantionElement("!"));
    assertEquals("Morning", s.longestWord());
    
    Sentence c = s.clone();

    assertNotEquals(s, c);
    assertEquals(s.toString(), c.toString());

  }
  
  @Test
  public void testToString() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuantionElement(","));
    s.addElement(new WordElement("Good"));
    s.addElement(new WordElement("Morning"));
    s.addElement(new PunctuantionElement("!"));
    assertEquals("Morning", s.toString);
    

  }

}
