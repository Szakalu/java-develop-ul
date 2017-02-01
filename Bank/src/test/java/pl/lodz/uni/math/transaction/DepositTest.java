package pl.lodz.uni.math.transaction;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.lodz.uni.math.client.Client;

public class DepositTest {
	
	private static Client clientTadzik;
	
	@BeforeClass
    public static void setClientsForTests() {
		
        clientTadzik = new Client(1,"Tadzik");
        clientTadzik.addAccount("123456789012345", "description");
        clientTadzik.getBankAccount("123456789012345").setAmount(new BigDecimal(2000));
    }
	
	@Test
	public void testDepositDoTransaction(){
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				clientTadzik.getBankAccount("123456789012345"), 1000, 
				"description", TransactionType.DEPOSIT, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		new Deposit(valuesForTransaction);
		
	}
	
	@Test
	public void testDepositReturnAccountAmount(){
		assertEquals(clientTadzik.getBankAccount("123456789012345").getAmount(),new BigDecimal(3000));
		
	}
}
