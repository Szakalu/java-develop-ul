package pl.lodz.uni.math.bank;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.lodz.uni.math.client.Client;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;

public class BankAccountTest {
	private static Client clientTadzikMock;
	private static BankAccount bankAccountTadzik;
	private static BankAccount bankAccountTadzikMock;
	private static BankAccount bankAccountWithError;
	
	@BeforeClass
    public static void setBackAccountsForTests() {
		
        clientTadzikMock = EasyMock.createMock(Client.class);
        EasyMock.expect(clientTadzikMock.getId()).andReturn(1).anyTimes();
        EasyMock.expect(clientTadzikMock.getName()).andReturn("Tadzik").anyTimes();
        
        EasyMock.replay(clientTadzikMock);
        
        bankAccountTadzik = new BankAccount("123456789012345","description",clientTadzikMock);
        
        bankAccountTadzikMock = EasyMock.createMock(BankAccount.class);
        EasyMock.expect(bankAccountTadzikMock.getNumber()).andReturn("123456789012345").anyTimes();
        EasyMock.expect(bankAccountTadzikMock.getDescription()).andReturn("description").anyTimes();
        EasyMock.expect(bankAccountTadzikMock.getClient()).andReturn(clientTadzikMock).anyTimes();
        
        EasyMock.replay(bankAccountTadzikMock);
    }
	
	@Test
	public void testBankAccountConstructor(){
		assertEquals(bankAccountTadzikMock.getNumber(), bankAccountTadzik.getNumber());
		assertEquals(bankAccountTadzikMock.getClient(), clientTadzikMock);
	}
	
	@Test
	public void testBankAccountWithNoClient(){
		BankAccount bankAccountWithNoClient = new BankAccount();
		assertEquals(null, bankAccountWithNoClient.getClient());
	}
	
	@Test(expected=WrongBankAccountNumberException.class)
	public void testBankAccountWithWrongNumberLength(){
		bankAccountWithError = new BankAccount("12345678901234567890","description",clientTadzikMock);
	}
	
	@Test(expected=WrongBankAccountNumberException.class)
	public void testBankAccountWithOtherSignsNotOnlyNumbers(){
		bankAccountWithError = new BankAccount("123456789012E45","description",clientTadzikMock);
	}
	
	@Test(expected=EmptyBankAccountDescriptionException.class)
	public void testBankAccountWithNoDescription(){
		bankAccountWithError = new BankAccount("123456789012345","",clientTadzikMock);
	}
}
