package pl.lodz.uni.math.client;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test.None;

import pl.lodz.uni.math.bank.BankAccount;
import pl.lodz.uni.math.exceptions.WrongClientNameException;;

public class ClientTest {
	
	private static Client clientTadzik;
	private static Client clientTadzikMock;
	private static Client clientWithError;
	
	@BeforeClass
    public static void setClientsForTests() {
		clientTadzik = new Client(1, "Tadzik");
		clientTadzik.addAccount("123456789012345", "stuff");
		
        clientTadzikMock = EasyMock.createMock(Client.class);
        EasyMock.expect(clientTadzikMock.getId()).andReturn(1).anyTimes();
        EasyMock.expect(clientTadzikMock.getName()).andReturn("Tadzik").anyTimes();
        EasyMock.expect(clientTadzikMock.getBankAccount("123456789012345")).andReturn(
        		clientTadzik.getBankAccount("123456789012345")).anyTimes();
        
        EasyMock.replay(clientTadzikMock);
    }
	
	@Test
	public void testClientConstructorGetId(){
		assertEquals(clientTadzik.getId(),clientTadzikMock.getId());
	}
	
	@Test
	public void testClientConstructorGetName(){
		assertEquals(clientTadzik.getName(), clientTadzikMock.getName());
	}
	
	@Test(expected=WrongClientNameException.class)
	public void testClientConstructorWrongNameLengthToSmall(){
		clientWithError = new Client(2,"ON");
	}
	
	@Test(expected=WrongClientNameException.class)
	public void testClientConstructorWrongNameLengthToLong(){
		clientWithError = new Client(2,"qwertyuiopasdfghjklzxcvbnm");
	}
	
	@Test(expected=WrongClientNameException.class)
	public void testClientConstructorWrongNameNotOnlyLetters(){
		clientWithError = new Client(2,"Tadzik2");
	}
	
	@Test
	public void testClientAddingBankAccount(){
		assertEquals(clientTadzik.getBankAccount("123456789012345").getNumber(),clientTadzikMock.getBankAccount("123456789012345").getNumber());
		assertEquals(clientTadzik.getBankAccount("123456789012345").getDescription(),clientTadzikMock.getBankAccount("123456789012345").getDescription());
	}
	
	@Test
	public void testClientGetAccount(){
		assertEquals(clientTadzik.getBankAccount("123456789012345").getClient(), clientTadzik);
	}
	
	@Test
	public void testClientGetAccountWrongAccountNumber(){
		assertEquals(clientTadzik.getBankAccount("123456789012346").getClient(), null);
	}
}