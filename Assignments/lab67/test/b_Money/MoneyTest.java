package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100, SEK10p5;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
		SEK10p5 = new Money(1050, SEK);

	}

	@Test
	public void testGetAmount() {
		assertEquals(Integer.valueOf(10000), SEK100.getAmount()); //Make sure different currencies work
		assertEquals(Integer.valueOf(1000), EUR10.getAmount());
		assertEquals(Integer.valueOf(20000), SEK200.getAmount());
		assertEquals(Integer.valueOf(0), SEK0.getAmount()); //Make sure 0 values work
		assertEquals(Integer.valueOf(0), EUR0.getAmount());
		assertEquals(Integer.valueOf(-10000), SEKn100.getAmount()); //Make sure negative values work
	}

	@Test
	public void testGetCurrency() { //Just in case, go through all the previously defined monies
		assertEquals(SEK, SEK100.getCurrency());
		assertEquals(EUR, EUR10.getCurrency());
		assertEquals(SEK, SEK200.getCurrency());
		assertEquals(SEK, SEK0.getCurrency());
		assertEquals(EUR, EUR0.getCurrency());
		assertEquals(SEK, SEKn100.getCurrency());

	}

	@Test
	public void testToString() {
		assertEquals("10.5 SEK", SEK10p5.toString()); //Check monies that have a decimal value
		assertNotEquals("10.0 SEK", SEK10p5.toString()); //Check regular monies
		assertEquals("100.0 SEK", SEK100.toString());
		assertEquals("10.0 EUR", EUR10.toString());
		assertEquals("200.0 SEK", SEK200.toString());
		assertEquals("0.0 SEK", SEK0.toString()); //Check 0 monies
		assertEquals("0.0 EUR", EUR0.toString());
		assertEquals("-100.0 SEK", SEKn100.toString()); //Check negative monies
	}

	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf(150000), SEK100.universalValue()); //Check if SEK100 and EUR10 will return same value
		assertEquals(Integer.valueOf(150000), EUR10.universalValue());
		assertEquals(Integer.valueOf(300000), SEK200.universalValue());
		assertEquals(Integer.valueOf(0), SEK0.universalValue()); //Check if 0 values return 0
		assertEquals(Integer.valueOf(0), EUR0.universalValue());
		assertEquals(Integer.valueOf(-150000), SEKn100.universalValue()); //Check for negatives
	}

	@Test
	public void testEqualsMoney() {
		assertTrue(SEK100.equals(SEK100)); //Positive test case
		assertFalse(SEK100.equals(SEK200)); //Negative test case
		assertTrue(SEK0.equals(EUR0)); //0 test case
	}

	@Test
	public void testAdd() {
		assertEquals(Integer.valueOf(300000), SEK100.add(SEK100).universalValue());
		assertEquals(Integer.valueOf(300000), EUR10.add(SEK100).universalValue()); //Check if different currenies work
		assertEquals(Integer.valueOf(150000), SEK100.add(EUR0).universalValue()); //Check for zeroes
		assertEquals(Integer.valueOf(150000), SEK100.add(SEK0).universalValue());
		assertEquals(Integer.valueOf(0), SEK100.add(SEKn100).universalValue()); //Check for negatives in bot directions
		assertEquals(Integer.valueOf(0), SEKn100.add(SEK100).universalValue());
	}

	@Test
	public void testSub() {
		assertEquals(Integer.valueOf(0), SEK100.sub(SEK100).universalValue()); //Normal test case
		assertEquals(Integer.valueOf(0), EUR10.sub(SEK100).universalValue());
		assertEquals(Integer.valueOf(150000), SEK100.sub(EUR0).universalValue()); //Check subtracting 0
		assertEquals(Integer.valueOf(150000), SEK100.sub(SEK0).universalValue());
		assertEquals(Integer.valueOf(-150000), EUR0.sub(SEK100).universalValue()); //Test negative result
		assertEquals(Integer.valueOf(-150000), SEK0.sub(SEK100).universalValue());
		assertEquals(Integer.valueOf(300000), SEK100.sub(SEKn100).universalValue()); //Check negatives both directions
		assertEquals(Integer.valueOf(-300000), SEKn100.sub(SEK100).universalValue());
	}

	@Test
	public void testIsZero() {
		assertTrue(SEK0.isZero()); //Check normal monies
		assertTrue(EUR0.isZero());
		assertTrue(EUR10.sub(SEK100).isZero()); //Check arithmetic operation results
		assertTrue(SEK100.add(SEKn100).isZero());
	}

	@Test
	public void testNegate() {
		assertTrue(SEK100.sub(SEK100).negate().isZero()); //Test arithmetic operations
		assertTrue(EUR10.sub(SEK100).negate().isZero());
		assertEquals(Integer.valueOf(150000), EUR0.sub(SEK100).negate().universalValue()); //Check regular value
		assertEquals(Integer.valueOf(-150000), SEK100.negate().universalValue());
		assertEquals(Integer.valueOf(-150000), EUR10.negate().universalValue());
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, EUR10.compareTo(SEK100));
		assertEquals(-1, EUR10.compareTo(SEK200));
		assertEquals(1, SEK200.compareTo(EUR10));
		assertEquals(-1, SEKn100.compareTo(SEK100));
		assertEquals(1, SEK100.compareTo(SEKn100));
	}
}
