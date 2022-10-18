import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Bishop class.
 */
public class BishopTest {

  private Bishop BlackBishop;
  private Bishop WhiteBishop;
  private Bishop ZeroBishop;
  
  @Before
  public void setUp() throws Exception {
    ZeroBishop = new Bishop(0, 0, Color.BLACK);
    WhiteBishop = new Bishop(7, 7, Color.WHITE);
    BlackBishop = new Bishop(1, 1, Color.BLACK);
    
  }

  /**
   * Tests IllegalArgumentException situation.
   */
  @Test
  public void testInvalidBishop() {
      try {
        new Bishop(-1, -2, Color.BLACK);
        fail("Did not throw exception on row and col below 0");
      } catch (IllegalArgumentException e) {
        // do nothing
      }
      try {
        new Bishop(8, 0, Color.BLACK);
        fail("Did not throw exception on col bigger than 7");
      } catch (IllegalArgumentException e) {
        // do nothing
      }
      try {
        new Bishop(-2, 8, Color.BLACK);
        fail("Did not throw exception on row below 0 and col bigger than 7");
      } catch (IllegalArgumentException e) {
        // do nothing
      }
   }
  
  /**
   * Tests getRow method.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, ZeroBishop.getRow());
    assertEquals(7, WhiteBishop.getRow());
    assertEquals(1, BlackBishop.getRow());
  }
  
  /**
   * Tests getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, ZeroBishop.getColumn());
    assertEquals(7, WhiteBishop.getColumn());
    assertEquals(1, BlackBishop.getColumn());
  }
  
  /**
   * Tests getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, ZeroBishop.getColor());
    assertEquals(Color.WHITE, WhiteBishop.getColor());
    assertEquals(Color.BLACK, BlackBishop.getColor());
  }
  
  
  /**
   * Tests if it can move to a given cell as a boolean.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, ZeroBishop.canMove(0,0));
    assertEquals(true, ZeroBishop.canMove(1,1));
    assertEquals(true, ZeroBishop.canMove(7,7));
    assertEquals(false, ZeroBishop.canMove(5,4));
    
    try {
      ZeroBishop.canMove(8,8);
      fail("Did not throw exception when given cell out of the board");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      ZeroBishop.canMove(-1,0);
      fail("Did not throw exception when given cell out of the board");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }
  
  /**
   * Tests if it can kill a provided piece starting from where it currently is.
   */
  @Test
  public void testCanKill() {
    Bishop testBishop = new Bishop(1, 2, Color.WHITE);
    Bishop test2Bishop = new Bishop(1, 1, Color.WHITE);
    
    assertEquals(true, ZeroBishop.canKill(WhiteBishop));
    assertEquals(false, ZeroBishop.canKill(BlackBishop));
    assertEquals(false, ZeroBishop.canKill(testBishop));
    assertEquals(true, ZeroBishop.canKill(test2Bishop));
    
    try {
      ZeroBishop.canKill(ZeroBishop);
      fail("Did not throw exception when provided piece is yourself");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }
  
  
}
