package pl.lodz.uni.math.transaction;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.lodz.uni.math.client.Client;
import pl.lodz.uni.math.exceptions.BankAccountNotEnoughMoneyException;

public class CheckTest {
	
	private static Client clientTadzik;
	
	@BeforeClass
    public static void setClientsForTests() {
		
        clientTadzik = new Client(1,"Tadzik");
        clientTadzik.addAccount("123456789012345", "description");
        clientTadzik.getBankAccount("123456789012345").setAmount(new BigDecimal(2000));
    }
	
	@Test
	public void testCheckDoTransaction(){
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				clientTadzik.getBankAccount("123456789012345"), 1000, 
				"description", TransactionType.CHECK, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		new Check(valuesForTransaction);
		
	}
	
	@Test
	public void testCheckReturnAccountAmount(){
		assertEquals(clientTadzik.getBankAccount("123456789012345").getAmount(),new BigDecimal(1000));
		
	}
	
	@Test(expected=BankAccountNotEnoughMoneyException.class)
	public void testCheckNotEnoughMoney(){
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				clientTadzik.getBankAccount("123456789012345"), 10000, 
				"description", TransactionType.CHECK, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		new Check(valuesForTransaction);
		
	}
}
