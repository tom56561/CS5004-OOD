import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {

  private Bishop BlackBishop;
  private Bishop WhiteBishop;
  
  @Before
  public void setUp() throws Exception {
    BlackBishop = new Bishop(0, 0, Color.BLACK);
    WhiteBishop = new Bishop(5, 5, Color.WHITE);
  }

  @Test
  public void test() {
    fail("Not yet implemented");
  }

}
