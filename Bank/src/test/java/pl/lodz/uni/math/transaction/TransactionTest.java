package pl.lodz.uni.math.transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.lodz.uni.math.bank.BankAccount;
import pl.lodz.uni.math.client.Client;
import pl.lodz.uni.math.exceptions.BankAccountHaveOtherOwnerException;
import pl.lodz.uni.math.exceptions.BankAccountNotExistException;
import static org.junit.Assert.*;

public class TransactionTest {
	
	private static Client clientTadzik;
	private static Client clientJoe;
	private static Transaction transactionForTests;
	private static List<Transaction> transactionListForTests = new ArrayList<Transaction>();
	
	@BeforeClass
    public static void setClientsForTests() {
		
        clientTadzik = new Client(1,"Tadzik");
        clientTadzik.addAccount("123456789012345", "description");
        clientTadzik.getBankAccount("123456789012345").setAmount(new BigDecimal(2000));
        
        clientJoe = new Client(2,"Joe");
        clientJoe.addAccount("123456789012346", "description");
        
        ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				clientTadzik.getBankAccount("123456789012345"), 1000, 
				"description", TransactionType.DEPOSIT, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		transactionForTests = new Deposit(valuesForTransaction);
		
		transactionListForTests.add(transactionForTests);
    }
	
	@Test
	public void testTransactionHistoryForClient(){
		assertEquals(transactionListForTests, transactionForTests.getClientTransactionHistory(clientTadzik));
	}
	
	@Test(expected=BankAccountHaveOtherOwnerException.class)
	public void testTransactionWrongAccountOwner(){
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				clientJoe.getBankAccount("123456789012346"), 1000, 
				"description", TransactionType.DEPOSIT, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		new Deposit(valuesForTransaction);
		
	}
	
	@Test(expected=BankAccountNotExistException.class)
	public void testDepositReturnAccountAmount(){
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(clientTadzik, 
				new BankAccount(), 1000, 
				"description", TransactionType.DEPOSIT, clientTadzik.getBankAccount("123456789012345").getCheckNumber());
		new Deposit(valuesForTransaction);
	}
}
