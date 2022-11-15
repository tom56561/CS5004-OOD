import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

public class MarbleSolitaireModelImplTest {

  private MarbleSolitaireModelImpl gameNull;
  private MarbleSolitaireModelImpl game_a;
  private MarbleSolitaireModelImpl game_r_c;
  private MarbleSolitaireModelImpl game_a_r_c;

  /**
   * Initializes values used for testing.
   */
  @Before
  public void setUp() {
    gameNull = new MarbleSolitaireModelImpl();
    game_a = new MarbleSolitaireModelImpl(3);
    game_r_c = new MarbleSolitaireModelImpl(2, 3);
    game_a_r_c = new MarbleSolitaireModelImpl(5, 4, 3);
  }
  
  @Test
  public void testInvalidConstruct() {
    try {
      new MarbleSolitaireModelImpl(1, 5);
      fail("Did not throw exception on Invalid empty cell position");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new MarbleSolitaireModelImpl(6);
      fail("Did not throw exception on armThickness argument is invalid");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new MarbleSolitaireModelImpl(5, 2, 2);
      fail("Did not throw exception on Invalid empty cell position ");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }
  
  @Test
  public void testGetGameState() {
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", gameNull.getGameState());
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", game_r_c.getGameState());
    assertEquals("        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", new MarbleSolitaireModelImpl(5).getGameState());
    assertEquals("        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O _ O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", game_a_r_c.getGameState());
    
  }
  
  @Test
  public void testMove() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", gameNull.getGameState());
    gameNull.move(3,1, 3,3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", gameNull.getGameState());
    gameNull.move(5,2,3,2);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O", gameNull.getGameState());
    gameNull.move(2,2,4,2);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O _ O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    _ O O\n" +
            "    O O O", gameNull.getGameState());
    gameNull.move(2,4,2,2);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O _ _ O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    _ O O\n" +
            "    O O O", gameNull.getGameState());
    try {
      gameNull.move(3, 2, 1, 1);
      fail("Did not throw exception on Invalid move");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      gameNull.move(4, 4, 4, 2);
      fail("Did not throw exception on Invalid move");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      gameNull.move(3, 3, 2, 3);
      fail("Did not throw exception on Invalid move");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }
  
  @Test
  public void testIsGameOver() {
    assertEquals(false, gameNull.isGameOver());
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", gameNull.getGameState());
    gameNull.move(1, 3, 3, 3);
    gameNull.move(4, 3, 2, 3);
    gameNull.move(6, 3, 4, 3);
    assertEquals(false, gameNull.isGameOver());
    gameNull.move(3, 1, 3, 3);
    assertEquals(false, gameNull.isGameOver());
    gameNull.move(3, 4, 3, 2);
    assertEquals(false, gameNull.isGameOver());
    gameNull.move(3, 6, 3, 4);
    assertEquals(true, gameNull.isGameOver());
    assertEquals("    O O O\n" +
        "    O _ O\n" +
        "O O O O O O O\n" +
        "O _ O _ O _ _\n" +
        "O O O O O O O\n" +
        "    O _ O\n" +
        "    O _ O", gameNull.getGameState());
  }
  
  @Test
  public void testetScore() {
    assertEquals(32, gameNull.getScore());
    gameNull.move(1, 3, 3, 3);
    assertEquals(31, gameNull.getScore());
    gameNull.move(4, 3, 2, 3);
    assertEquals(30, gameNull.getScore());
    gameNull.move(6, 3, 4, 3);
    assertEquals(29, gameNull.getScore());
    assertEquals(104, game_a_r_c.getScore());
    game_a_r_c.move(4, 1, 4, 3);
    assertEquals(103, game_a_r_c.getScore());
  }

  
  

}
