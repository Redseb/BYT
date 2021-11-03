package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		SweBank.openAccount("TestID");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(0), SweBank.getBalance("TestID"));
		testAccount.addTimedPayment("payID1", 5, 5, new Money(100, SEK), SweBank, "TestID");
		testAccount.removeTimedPayment( "payID1");
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(0), SweBank.getBalance("TestID"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(0), SweBank.getBalance("TestID"));
		testAccount.addTimedPayment("payID1", 5, 5, new Money(100, SEK), SweBank, "TestID");
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		assertEquals(Integer.valueOf(9999900), testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(100), SweBank.getBalance("TestID"));
	}

	@Test
	public void testAddWithdraw() {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		testAccount.deposit(new Money(10000000, SEK));
		assertEquals(Integer.valueOf(20000000), testAccount.getBalance().getAmount());
		testAccount.withdraw(new Money(10000000, SEK));
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		assertEquals(SEK, testAccount.getBalance().getCurrency());
		//Not sure what else to test here...
	}
}
