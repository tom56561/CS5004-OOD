import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SentenceImplTest {
  Sentence s;

  @Test
  public void testGenericGetNumberOf() {
    Sentence s;
    s = new SentenceImpl();
    assertEquals(0, s.genericGetNumberOf(element -> element.isWord()));
    s.addElement(new WordElement("Hello"));
    assertEquals(1, s.genericGetNumberOf(element -> element.isWord()));
    s.addElement(new WordElement("Word"));
    assertEquals(2, s.genericGetNumberOf(element -> element.isWord()));
    s.addElement(new PunctuationElement("!"));
    assertEquals(2, s.genericGetNumberOf(element -> element.isWord()));

    s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuationElement(","));
    s.addElement(new WordElement("Good"));
    s.addElement(new WordElement("Morning"));
    s.addElement(new PunctuationElement("!"));
    assertEquals(1, s
        .genericGetNumberOf(element -> element.isWord() && element.toString().trim().length() > 5));
    assertEquals(2, s.genericGetNumberOf(element -> !(element.isWord())));

  }

  @Test
  public void testGetNumberOfWords() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new WordElement("Word"));
    s.addElement(new PunctuationElement("!"));

    assertEquals(2, s.getNumberOfWords());

  }

  @Test
  public void testLongestWord() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuationElement(","));
    s.addElement(new WordElement("Good"));
    s.addElement(new WordElement("Morning"));
    s.addElement(new PunctuationElement("!"));
    assertEquals("Morning", s.longestWord());

    s = new SentenceImpl();
    s.addElement(new WordElement("How"));
    s.addElement(new WordElement("are"));
    s.addElement(new WordElement("you"));
    s.addElement(new PunctuationElement("?"));
    assertEquals("How", s.longestWord());

    s = new SentenceImpl();
    s.addElement(new WordElement("See"));
    s.addElement(new WordElement("you"));
    s.addElement(new WordElement("tomorrow"));
    s.addElement(new PunctuationElement("!"));
    assertEquals("tomorrow", s.longestWord());

  }

  @Test
  public void testClone() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuationElement(","));
    s.addElement(new WordElement("Good"));
    s.addElement(new WordElement("Morning"));
    s.addElement(new PunctuationElement("!"));

    String str = s.toString();
    Sentence c = s.clone();

    assertNotEquals(s, c);
    assertEquals(s.toString(), c.toString());

    s.addElement(new WordElement("Extra"));
    assertEquals(str, c.toString());

//    SentenceImpl original = (SentenceImpl) s;
//    SentenceImpl clone = (SentenceImpl) c;
////    assertNotEquals(original., c);
//    clone.sentence.add
//    assertEquals(str, s.toString());

  }

  @Test
  public void testMerge() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuationElement(","));
    s.addElement(new WordElement("Good"));
    s.addElement(new WordElement("Morning"));
    s.addElement(new PunctuationElement("!"));

    Sentence o = new SentenceImpl();
    o.addElement(new WordElement("Have"));
    o.addElement(new WordElement("a"));
    o.addElement(new WordElement("nice"));
    o.addElement(new WordElement("day"));
    o.addElement(new PunctuationElement("."));

    String sString = s.toString();
    String oString = o.toString();
    Sentence m = s.merger(o);
    String mString = m.toString();

    assertEquals(s.toString() + " " + o.toString(), m.toString());
    assertEquals(sString, s.toString());
    assertEquals(oString, o.toString());

    s.addElement(new WordElement("Extra"));
    assertEquals(mString, m.toString());
    
    o.addElement(new WordElement("Oops"));
    assertEquals(mString, m.toString());
    
    m.addElement(new WordElement("new"));
    assertEquals(sString + " Extra.", s.toString());
    assertEquals(oString + " Oops.", o.toString());

  }

  @Test
  public void testGetNumberOfPunctuation() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuationElement("!"));
    s.addElement(new WordElement("Word"));
    s.addElement(new WordElement("Word"));
    s.addElement(new PunctuationElement("!"));

    assertEquals(2, s.getNumberOfPunctuation());

  }

  @Test
  public void testGetNumberOfZ() {

    int expected;
    int actual;
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Going"));
    s.addElement(new WordElement("to"));
    s.addElement(new WordElement("the"));
    s.addElement(new WordElement("zoo"));
    s.addElement(new PunctuationElement("!"));
    expected = 1;
    actual = s.getNumberOfZ();
    assertEquals(expected, actual);

    s = new SentenceImpl();
    s.addElement(new WordElement("zppotia"));
    s.addElement(new WordElement("to"));
    s.addElement(new WordElement("the"));
    s.addElement(new WordElement("zoo"));
    s.addElement(new PunctuationElement("!"));
    expected = 2;
    actual = s.getNumberOfZ();
    assertEquals(expected, actual);
  }

  @Test
  public void testToString() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("See"));
    s.addElement(new WordElement("you"));
    s.addElement(new WordElement("tomorrow"));
    s.addElement(new PunctuationElement("!"));
    assertEquals("See you tomorrow!", s.toString());

    s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuationElement(","));
    s.addElement(new WordElement("good"));
    s.addElement(new WordElement("morning"));
    s.addElement(new PunctuationElement("!"));
    assertEquals("Hello, good morning!", s.toString());

    s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new WordElement("world"));
    assertEquals("Hello world.", s.toString());

  }
  
  @Test
  public void testTranlateToPigLatin() {
    Sentence s = new SentenceImpl();
    s.addElement(new WordElement("Hello"));
    s.addElement(new PunctuationElement(","));
    s.addElement(new WordElement("Good"));
    s.addElement(new WordElement("Morning"));
    s.addElement(new PunctuationElement("!"));
    String expected = "elloHay, oodGay orningMay!";
    assertEquals(expected, s.tranlateToPigLatin().toString());
    
    s = new SentenceImpl();
    s.addElement(new WordElement("How"));
    s.addElement(new WordElement("are"));
    s.addElement(new WordElement("you"));
    s.addElement(new WordElement("Alexis"));
    s.addElement(new PunctuationElement("?"));
    expected = "owHay areway youway Alexisway?";
    assertEquals(expected, s.tranlateToPigLatin().toString());
  }


}
