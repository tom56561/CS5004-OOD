
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Bishop class.
 */
public class BishopTest {

  private Bishop zeroBishop;
  private Bishop blackBishop;
  private Bishop whiteBishop;

  @Before
  public void setUp() throws Exception {
    zeroBishop = new Bishop(0, 0, Color.BLACK);
    blackBishop = new Bishop(1, 1, Color.BLACK);
    whiteBishop = new Bishop(7, 7, Color.WHITE);

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
    assertEquals(0, zeroBishop.getRow());
    assertEquals(7, whiteBishop.getRow());
    assertEquals(1, blackBishop.getRow());
  }

  /**
   * Tests getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, zeroBishop.getColumn());
    assertEquals(7, whiteBishop.getColumn());
    assertEquals(1, blackBishop.getColumn());
  }

  /**
   * Tests getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, zeroBishop.getColor());
    assertEquals(Color.BLACK, blackBishop.getColor());
    assertEquals(Color.WHITE, whiteBishop.getColor());
  }

  /**
   * Tests if it can move to a given cell as a boolean.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, zeroBishop.canMove(0, 0));
    assertEquals(true, zeroBishop.canMove(1, 1));
    assertEquals(true, zeroBishop.canMove(7, 7));
    assertEquals(false, zeroBishop.canMove(5, 4));

    try {
      zeroBishop.canMove(8, 8);
      fail("Did not throw exception when given cell out of the board");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      zeroBishop.canMove(-1, 0);
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
    Rook testRook = new Rook(1, 0, Color.BLACK);
    Queen testQueen = new Queen(7, 7, Color.WHITE);

    assertEquals(true, zeroBishop.canKill(whiteBishop));
    assertEquals(false, zeroBishop.canKill(blackBishop));
    assertEquals(false, zeroBishop.canKill(testBishop));
    assertEquals(true, zeroBishop.canKill(test2Bishop));
    assertEquals(false, zeroBishop.canKill(testRook));
    assertEquals(true, zeroBishop.canKill(testQueen));

    try {
      zeroBishop.canKill(zeroBishop);
      fail("Did not throw exception when provided piece is yourself");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

}
