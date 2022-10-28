import static org.junit.Assert.*;

import org.junit.Test;

public class KitchenItemTest {

  @Test
  public void test() {
    KitchenItem k = new KitchenItem(2, 10 ,5);
    
    assertEquals(10, k.valueOfStock(), 0.1);
    
    ClothingItem c = new ClothingItem(2, 10, 5, Collection.SPRING);
    
    assertEquals(10, c.valueOfStock(), 0.1);
  }

}
