package lab01;

/**
 * This class represents a person The person has a first name, 
 * last name, an year of birth, a phone and an email.
 */
public class Person {
  private String firstName;
  private String lastName;
  private int yearOfBirth;
  private int phone;
  private Contact email;
  


  /**
   * Constructs a Person object and initializes it to the given first name, last name and year of
   * birth.
   *
   * @param firstName   the first name of this person
   * @param lastName    the last name of this person
   * @param yearOfBirth the year of birth of this person
   * @param phone the phone of this person
   * @param email the email of this person
   */

  public Person(String firstName, String lastName, int yearOfBirth, int phone, Contact email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.yearOfBirth = yearOfBirth;
    this.phone = phone;
    this.email = email;
  }

  /**
   * Get the first name of this person.
   *
   * @return the first name of this person
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return the last name of this person.
   *
   * @return the last name of this person
   */

  public String getLastName() {
    return this.lastName;
  }

  /**
   * Return the year of birth of this person.
   *
   * @return the year of birth of this person
   */
  public int getYearOfBirth() {
    return this.yearOfBirth;
  }
  
  /**
   * Return the age of this person in 2020.
   * @return the age of this person in 2020
   */
  public int getAge() {
    return 2020 - this.yearOfBirth;
  }

  /**
   * Return the full name of this person.
   * @return the full name this person
   */
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
  
  /**
   * Return the phone of this person.
   * @return the phone this person
   */
  public int getPhone() {
    return this.phone;
  }
  
  
  /**
   * Return the email of this person.
   * @return the email this person
   */
  public Contact getEmail() {
    return this.email;
  }
}

