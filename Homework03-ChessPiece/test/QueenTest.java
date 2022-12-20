import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Queen class.
 */
public class QueenTest {

  private Queen zeroQueen;
  private Queen blackQueen;
  private Queen whiteQueen;

  @Before
  public void setUp() throws Exception {
    zeroQueen = new Queen(0, 0, Color.BLACK);
    blackQueen = new Queen(5, 1, Color.BLACK);
    whiteQueen = new Queen(7, 0, Color.WHITE);
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
    assertEquals(0, zeroQueen.getRow());
    assertEquals(5, blackQueen.getRow());
    assertEquals(7, whiteQueen.getRow());
  }

  /**
   * Tests getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, zeroQueen.getColumn());
    assertEquals(1, blackQueen.getColumn());
    assertEquals(0, whiteQueen.getColumn());
  }

  /**
   * Tests getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, zeroQueen.getColor());
    assertEquals(Color.BLACK, blackQueen.getColor());
    assertEquals(Color.WHITE, whiteQueen.getColor());
  }

  /**
   * Tests if it can move to a given cell as a boolean.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, zeroQueen.canMove(0, 0));
    assertEquals(true, zeroQueen.canMove(0, 7));
    assertEquals(true, zeroQueen.canMove(7, 7));
    assertEquals(false, zeroQueen.canMove(5, 4));
    assertEquals(false, blackQueen.canMove(1, 0));
    assertEquals(true, blackQueen.canMove(0, 1));

    try {
      zeroQueen.canMove(8, 8);
      fail("Did not throw exception when given cell out of the board");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      zeroQueen.canMove(-1, 0);
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
    Bishop testBishop = new Bishop(0, 2, Color.BLACK);
    Rook testRook = new Rook(5, 5, Color.WHITE);

    assertEquals(true, zeroQueen.canKill(whiteQueen));
    assertEquals(false, zeroQueen.canKill(blackQueen));
    assertEquals(false, zeroQueen.canKill(testQueen));
    assertEquals(true, zeroQueen.canKill(test2Queen));
    assertEquals(true, zeroQueen.canKill(test3Queen));
    assertEquals(false, zeroQueen.canKill(testBishop));
    assertEquals(true, zeroQueen.canKill(testRook));

    try {
      zeroQueen.canKill(zeroQueen);
      fail("Did not throw exception when provided piece is yourself");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

}
