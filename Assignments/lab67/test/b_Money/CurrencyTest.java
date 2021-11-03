package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
	}
	
	@Test
	public void testGetRate() {
		assertEquals( Double.valueOf(0.15), SEK.getRate());
		assertEquals(Double.valueOf(0.20), DKK.getRate());
		assertEquals(Double.valueOf(1.5), EUR.getRate());

	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.7);
		assertEquals(Double.valueOf(0.7), SEK.getRate());
		DKK.setRate(-0.5);
		assertEquals(Double.valueOf(-0.5), DKK.getRate());
		EUR.setRate(0.0);
		assertEquals(Double.valueOf(0.0), EUR.getRate());
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf(15), SEK.universalValue(1));
		assertEquals(Integer.valueOf(200), DKK.universalValue(10));
		assertEquals(Integer.valueOf(15000), EUR.universalValue(100));
		assertEquals(Integer.valueOf(150), EUR.universalValue(1));

	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals(Integer.valueOf(1), EUR.valueInThisCurrency(1, EUR)); //Test if 1 eur = 1 eur
		assertEquals(Integer.valueOf(40), EUR.valueInThisCurrency(300, DKK));
		assertEquals(Integer.valueOf(300), DKK.valueInThisCurrency(40, EUR));
	}

}
