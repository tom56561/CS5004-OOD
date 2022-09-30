package lab01;

import lab01.Person;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {

  private Person john;
  private Person sally;
  private Contact johnEmail;
  private Contact sallyEmail;


  @Before
  public void setUp() {
    johnEmail = new Contact("john123", "@gmail.com");
    sallyEmail = new Contact("sally123", "@yahoo.com");
    this.john = new Person("John", "Doe", 1945, 2071112222, this.johnEmail);
    this.sally = new Person("Sally", "Ride", 1951, 2072223333, this.sallyEmail);
  }
  
  @Test
  public void testFirst() {
    assertEquals("John", this.john.getFirstName());
    assertEquals("Sally", this.sally.getFirstName());
  }
  
  @Test
  public void testSecond() {
    assertEquals("Doe", john.getLastName());
    assertEquals("Ride", sally.getLastName());

  }

  @Test
  public void testYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
    assertEquals(1951, sally.getYearOfBirth());

  }
  
  @Test
  public void testAge() {
    assertEquals(75, this.john.getAge());
    assertEquals(69, this.sally.getAge());
  }

  @Test
  public void testFullName() {
    assertEquals("John Doe", this.john.getFullName());
    assertEquals("Sally Ride", this.sally.getFullName());
  }
  
  @Test
  public void testPhone() {
    assertEquals(2071112222, this.john.getPhone());
    assertEquals(2072223333, this.sally.getPhone());
  }
  
  @Test
  public void testEmail() {
    assertEquals("john123@gmail.com", this.johnEmail.getEmail());
    assertEquals("sally123@yahoo.com", this.sallyEmail.getEmail());
  }
  
}
  

