package lab01;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Contact class.
 */
public class ContactTest {

  private Contact john;
  private Contact sally;
  
  @Before
  public void setUp() {
    this.john = new Contact("john123", "@gmail.com");
    this.sally = new Contact("sally123", "@yahoo.com");
  }

  @Test
  public void testGetEmail() {
    assertEquals("john123@gmail.com", this.john.getEmail());
    assertEquals("sally123@yahoo.com", this.sally.getEmail());
  }

}
