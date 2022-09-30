package lab01;

/**
 * This class represents a contact email 
 * The contact email has an username and a domain.
 */
public class Contact {
  private String username;
  private String domain;
  
  /**
   * Construct a Contact object that has the provided email, phone.
   *
   * @param username the username of the person
   * @param domain the domain of the person
   */

  public Contact(String username, String domain) {
    this.username = username;
    this.domain = domain;
  }
  
  /**
   * Get the email of this person.
   *
   * @return the email of this person
   */
  public String getEmail() {
    return this.username + this.domain;
  }
  
  
}
