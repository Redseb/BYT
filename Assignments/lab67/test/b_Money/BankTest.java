package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
		assertEquals("DanskeBank", DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SweBank.getCurrency());
		assertEquals(SEK, Nordea.getCurrency());
		assertEquals(DKK, DanskeBank.getCurrency());
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("testID", new Money(1000, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("testID", new Money(1000, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionGetBalance() throws AccountDoesNotExistException {
		SweBank.getBalance("testID");
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionTransferTwoBanksFromDoesNotExist() throws AccountDoesNotExistException {
		SweBank.transfer("testID", Nordea, "Bob", new Money(1000, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionTransferTwoBanksToDoesNotExist() throws AccountDoesNotExistException {
		SweBank.transfer("Bob", Nordea, "testID", new Money(1000, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionTransferToDoesNotExist() throws AccountDoesNotExistException {
		SweBank.transfer("Bob", "testID", new Money(1000, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionTransferFromDoesNotExist() throws AccountDoesNotExistException {
		SweBank.transfer("testID", "Bob", new Money(1000, SEK));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionAddTimedPaymentFromDoesNotExist() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("testID", "payID", 100, 10, new Money(1000, SEK), SweBank, "bob");
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testAccountDoesNotExistExceptionTimedRemoveTimedPayment() throws AccountDoesNotExistException {
		SweBank.removeTimedPayment("testID", "payID");
	}

	@Test(expected = AccountExistsException.class)
	public void testAccountDoesExistsExceptionOpenAccount() throws AccountExistsException {
		SweBank.openAccount("Bob");
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("testID");
		assertEquals(Integer.valueOf(0), SweBank.getBalance("testID"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("Bob"));
		SweBank.deposit("Bob", new Money(-2000, SEK));
		assertEquals(Integer.valueOf(-1000), SweBank.getBalance("Bob"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(-1000), SweBank.getBalance("Bob"));
		SweBank.withdraw("Bob", new Money(-2000, SEK));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("Bob"));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException, AccountExistsException {
		SweBank.openAccount("testID");
		assertEquals(Integer.valueOf(0), SweBank.getBalance("testID"));
		SweBank.deposit("testID", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("testID"));
		SweBank.withdraw("testID", new Money(1000, SEK));
		assertEquals(Integer.valueOf(0), SweBank.getBalance("testID"));
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(0), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(0), SweBank.getBalance("Ulrika"));
		SweBank.transfer("Bob", "Ulrika", new Money(1000, SEK));
		assertEquals(Integer.valueOf(-1000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("Ulrika"));
		SweBank.transfer("Bob", Nordea,"Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(-2000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000), Nordea.getBalance("Bob"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Bob", "payID1", 5, 5, new Money(1000, SEK), SweBank, "Ulrika");
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		assertEquals(Integer.valueOf(-1000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("Ulrika"));
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		assertEquals(Integer.valueOf(-2000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(2000), SweBank.getBalance("Ulrika"));
		SweBank.removeTimedPayment("Bob", "payID1");
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		assertEquals(Integer.valueOf(-2000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(2000), SweBank.getBalance("Ulrika"));
	}
}
