

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void testSomethingImportant() {
		int expected = 3;
		assertEquals(expected, 3);
	}

	@Test
	public void testAnotherThing() {
		String expected = "Northeastern";
		assertEquals("Message", expected, "Northeastern");
	}
}
