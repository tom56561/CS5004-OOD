import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Rook class.
 */
public class RookTest {

  private Rook zeroRook;
  private Rook blackRook;
  private Rook whiteRook;

  @Before
  public void setUp() throws Exception {
    zeroRook = new Rook(0, 0, Color.BLACK);
    blackRook = new Rook(5, 1, Color.BLACK);
    whiteRook = new Rook(7, 0, Color.WHITE);
  }

  /**
   * Tests IllegalArgumentException situation.
   */
  @Test
  public void testInvalidQueen() {
    try {
      new Rook(-1, -2, Color.BLACK);
      fail("Did not throw exception on row and col below 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new Rook(8, 0, Color.BLACK);
      fail("Did not throw exception on col bigger than 7");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new Rook(-2, 8, Color.BLACK);
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
    assertEquals(0, zeroRook.getRow());
    assertEquals(5, blackRook.getRow());
    assertEquals(7, whiteRook.getRow());
  }

  /**
   * Tests getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, zeroRook.getColumn());
    assertEquals(1, blackRook.getColumn());
    assertEquals(0, whiteRook.getColumn());
  }

  /**
   * Tests getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, zeroRook.getColor());
    assertEquals(Color.BLACK, blackRook.getColor());
    assertEquals(Color.WHITE, whiteRook.getColor());
  }

  /**
   * Tests if it can move to a given cell as a boolean.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, zeroRook.canMove(0, 0));
    assertEquals(true, zeroRook.canMove(0, 7));
    assertEquals(false, zeroRook.canMove(7, 7));
    assertEquals(false, zeroRook.canMove(5, 4));
    assertEquals(false, blackRook.canMove(1, 0));
    assertEquals(true, blackRook.canMove(0, 1));

    try {
      zeroRook.canMove(8, 8);
      fail("Did not throw exception when given cell out of the board");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      zeroRook.canMove(-1, 0);
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
    Rook testRook = new Rook(1, 0, Color.BLACK);
    Rook test2Rook = new Rook(0, 7, Color.WHITE);
    Queen testQueen = new Queen(7, 0, Color.WHITE);
    Bishop testBishop = new Bishop(0, 2, Color.BLACK);

    assertEquals(true, zeroRook.canKill(whiteRook));
    assertEquals(false, zeroRook.canKill(blackRook));
    assertEquals(false, zeroRook.canKill(testRook));
    assertEquals(true, zeroRook.canKill(test2Rook));
    assertEquals(true, zeroRook.canKill(testQueen));
    assertEquals(false, zeroRook.canKill(testBishop));

    try {
      zeroRook.canKill(zeroRook);
      fail("Did not throw exception when provided piece is yourself");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

}
