package pl.lodz.uni.math.transaction;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.lodz.uni.math.bank.BankAccount;
import pl.lodz.uni.math.client.Client;
import pl.lodz.uni.math.exceptions.BankAccountNotEnoughMoneyException;
import pl.lodz.uni.math.exceptions.BankAccountNotExistException;


public class WireoutTest {

	private static Client clientTadzik;
	private static Client clientJoe;
	
	@BeforeClass
    public static void setClientsForTests() {
		
        clientTadzik = new Client(1,"Tadzik");
        clientTadzik.addAccount("123456789012345", "description");
        clientTadzik.getBankAccount("123456789012345").setAmount(new BigDecimal(2000));

        clientJoe = new Client(2, "Joe");
        clientJoe.addAccount("123456789012346", "description");
        clientJoe.getBankAccount("123456789012346").setAmount(new BigDecimal(1000));
    }
	
	@Test
	public void testWireoutDoTransaction(){
		clientTadzik.getBankAccount("123456789012345").setAmount(new BigDecimal(2000));
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				clientTadzik.getBankAccount("123456789012345"), 1000, 
				"description", TransactionType.CHECK, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		new Wireout(valuesForTransaction,clientJoe.getBankAccount("123456789012346"),"12345","12345");
		
	}
	
	@Test
	public void testWireoutReturnAccountAmount(){
		assertEquals(clientTadzik.getBankAccount("123456789012345").getAmount(),new BigDecimal(1000));
		assertEquals(clientJoe.getBankAccount("123456789012346").getAmount(),new BigDecimal(2000));
	}
	
	@Test(expected=BankAccountNotExistException.class)
	public void testWireoutWrongGetterAccount(){
		BankAccount bankAccountWithNoClient = new BankAccount();
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				clientTadzik.getBankAccount("123456789012345"), 1000, 
				"description", TransactionType.CHECK, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		new Wireout(valuesForTransaction,bankAccountWithNoClient,"12345","12345");
	}
	
	@Test(expected=BankAccountNotEnoughMoneyException.class)
	public void testWireoutNotEnoughMoneyOnSenderAccount(){
		clientTadzik.getBankAccount("123456789012345").setAmount(new BigDecimal(0));
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				clientTadzik.getBankAccount("123456789012345"), 1000, 
				"description", TransactionType.CHECK, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		new Wireout(valuesForTransaction,clientJoe.getBankAccount("123456789012346"),"12345","12345");
	}

}