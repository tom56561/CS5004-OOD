import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Queen class.
 */
public class QueenTest {

  private Queen ZeroQueen;
  private Queen BlackQueen;
  private Queen WhiteQueen;

  @Before
  public void setUp() throws Exception {
    ZeroQueen = new Queen(0, 0, Color.BLACK);
    BlackQueen = new Queen(5, 1, Color.BLACK);
    WhiteQueen = new Queen(7, 0, Color.WHITE);
  }

  /**
   * Tests IllegalArgumentException situation.
   */
  @Test
  public void testInvalidQueen() {
    try {
      new Queen(-1, -2, Color.BLACK);
      fail("Did not throw exception on row and col below 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new Queen(8, 0, Color.BLACK);
      fail("Did not throw exception on col bigger than 7");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new Queen(-2, 8, Color.BLACK);
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
    assertEquals(0, ZeroQueen.getRow());
    assertEquals(5, BlackQueen.getRow());
    assertEquals(7, WhiteQueen.getRow());
  }

  /**
   * Tests getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, ZeroQueen.getColumn());
    assertEquals(1, BlackQueen.getColumn());
    assertEquals(0, WhiteQueen.getColumn());
  }

  /**
   * Tests getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, ZeroQueen.getColor());
    assertEquals(Color.BLACK, BlackQueen.getColor());
    assertEquals(Color.WHITE, WhiteQueen.getColor());
  }

  /**
   * Tests if it can move to a given cell as a boolean.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, ZeroQueen.canMove(0, 0));
    assertEquals(true, ZeroQueen.canMove(0, 7));
    assertEquals(true, ZeroQueen.canMove(7, 0));
    assertEquals(false, ZeroQueen.canMove(5, 4));
    assertEquals(false, BlackQueen.canMove(1, 0));
    assertEquals(true, BlackQueen.canMove(0, 1));

    try {
      ZeroQueen.canMove(8, 8);
      fail("Did not throw exception when given cell out of the board");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      ZeroQueen.canMove(-1, 0);
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
    Queen testQueen = new Queen(1, 0, Color.BLACK);
    Queen test2Queen = new Queen(0, 7, Color.WHITE);
    Queen test3Queen = new Queen(1, 1, Color.WHITE);
    
    assertEquals(true, ZeroQueen.canKill(WhiteQueen));
    assertEquals(false, ZeroQueen.canKill(BlackQueen));
    assertEquals(false, ZeroQueen.canKill(testQueen));
    assertEquals(true, ZeroQueen.canKill(test2Queen));
    assertEquals(true, ZeroQueen.canKill(test3Queen));

    try {
      ZeroQueen.canKill(ZeroQueen);
      fail("Did not throw exception when provided piece is yourself");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }
  
  
}
