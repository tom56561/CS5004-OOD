import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Pawn class.
 */
public class PawnTest {

  private Pawn zeroPawn;
  private Pawn blackPawn;
  private Pawn whitePawn;

  @Before
  public void setUp() throws Exception {
    zeroPawn = new Pawn(0, 0, Color.BLACK);
    blackPawn = new Pawn(5, 1, Color.BLACK);
    whitePawn = new Pawn(7, 0, Color.WHITE);
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
    assertEquals(0, zeroPawn.getRow());
    assertEquals(5, blackPawn.getRow());
    assertEquals(7, whitePawn.getRow());
  }

  /**
   * Tests getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, zeroPawn.getColumn());
    assertEquals(1, blackPawn.getColumn());
    assertEquals(0, whitePawn.getColumn());
  }

  /**
   * Tests getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, zeroPawn.getColor());
    assertEquals(Color.BLACK, blackPawn.getColor());
    assertEquals(Color.WHITE, whitePawn.getColor());
  }

  /**
   * Tests if it can move to a given cell as a boolean.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, zeroPawn.canMove(0, 0));
    assertEquals(true, zeroPawn.canMove(0, 1));
    assertEquals(false, zeroPawn.canMove(7, 7));
    assertEquals(false, whitePawn.canMove(7, 2));
    assertEquals(false, blackPawn.canMove(5, 0));
    assertEquals(true, blackPawn.canMove(5, 2));

    try {
      zeroPawn.canMove(8, 8);
      fail("Did not throw exception when given cell out of the board");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      zeroPawn.canMove(-1, 0);
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
    Pawn testPawn = new Pawn(1, 1, Color.BLACK);
    Pawn test2Pawn = new Pawn(1, 1, Color.WHITE);
    Queen testQueen = new Queen(6, 2, Color.WHITE);
    Bishop testBishop = new Bishop(4, 2, Color.BLACK);
    Rook testRook = new Rook(4, 2, Color.WHITE);

    assertEquals(false, zeroPawn.canKill(testPawn));
    assertEquals(true, zeroPawn.canKill(test2Pawn));
    assertEquals(true, blackPawn.canKill(testQueen));
    assertEquals(false, blackPawn.canKill(testBishop));
    assertEquals(true, blackPawn.canKill(testRook));

    try {
      zeroPawn.canKill(zeroPawn);
      fail("Did not throw exception when provided piece is yourself");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

}
