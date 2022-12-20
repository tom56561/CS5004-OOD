import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Queen class.
 */
public class KnightTest {

  private Knight zeroKnight;
  private Knight blackKnight;
  private Knight whiteKnight;

  @Before
  public void setUp() throws Exception {
    zeroKnight = new Knight(0, 0, Color.BLACK);
    blackKnight = new Knight(5, 5, Color.BLACK);
    whiteKnight = new Knight(7, 7, Color.WHITE);
  }

  /**
   * Tests IllegalArgumentException situation.
   */
  @Test
  public void testInvalidQueen() {
    try {
      new Knight(-1, -2, Color.BLACK);
      fail("Did not throw exception on row and col below 0");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new Knight(8, 0, Color.WHITE);
      fail("Did not throw exception on col bigger than 7");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new Knight(-2, 8, Color.BLACK);
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
    assertEquals(0, zeroKnight.getRow());
    assertEquals(5, blackKnight.getRow());
    assertEquals(7, whiteKnight.getRow());
  }

  /**
   * Tests getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, zeroKnight.getColumn());
    assertEquals(5, blackKnight.getColumn());
    assertEquals(7, whiteKnight.getColumn());
  }

  /**
   * Tests getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, zeroKnight.getColor());
    assertEquals(Color.BLACK, blackKnight.getColor());
    assertEquals(Color.WHITE, whiteKnight.getColor());
  }

  /**
   * Tests if it can move to a given cell as a boolean.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, zeroKnight.canMove(0, 0));
    assertEquals(true, zeroKnight.canMove(1, 2));
    assertEquals(true, zeroKnight.canMove(2, 1));
    assertEquals(true, blackKnight.canMove(4, 3));
    assertEquals(true, blackKnight.canMove(4, 7));
    assertEquals(false, blackKnight.canMove(5, 3));

    try {
      zeroKnight.canMove(8, 8);
      fail("Did not throw exception when given cell out of the board");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      zeroKnight.canMove(-1, 0);
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
    Knight testKnight = new Knight(1, 2, Color.BLACK);
    Knight test2Knight = new Knight(1, 2, Color.WHITE);
    Knight test3Knight = new Knight(6, 5, Color.BLACK);
    Bishop testBishop = new Bishop(1, 2, Color.BLACK);
    Rook testRook = new Rook(2, 1, Color.WHITE);

    assertEquals(false, zeroKnight.canKill(whiteKnight));
    assertEquals(false, zeroKnight.canKill(blackKnight));
    assertEquals(false, zeroKnight.canKill(testKnight));
    assertEquals(true, zeroKnight.canKill(test2Knight));
    assertEquals(true, whiteKnight.canKill(test3Knight));
    assertEquals(false, zeroKnight.canKill(testBishop));
    assertEquals(true, zeroKnight.canKill(testRook));

    try {
      zeroKnight.canKill(zeroKnight);
      fail("Did not throw exception when provided piece is yourself");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

}
