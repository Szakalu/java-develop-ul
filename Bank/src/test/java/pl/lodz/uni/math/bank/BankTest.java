package pl.lodz.uni.math.bank;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.lodz.uni.math.client.Client;
import pl.lodz.uni.math.exceptions.BankWrongNameException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;

public class BankTest {

	private static Bank bankTest;
	private static Client clientMock;
	
	
	@BeforeClass
    public static void setBankForTests() {
		
        bankTest = new Bank("Bank");
        
        clientMock = EasyMock.mock(Client.class);
        EasyMock.expect(clientMock.getId()).andReturn(1).anyTimes();
        
        EasyMock.replay(clientMock);
    }
	
	@Test
	public void testBankAddClient(){
		bankTest.addClient(clientMock);
		assertEquals(clientMock, bankTest.getClientsList().get(0));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testBankTryAddExistingClient(){
		bankTest.addClient(clientMock);
		assertEquals(clientMock, bankTest.getClientsList().get(1));
	}
	
	@Test
	public void testBankRemoveClient(){
		bankTest.removeClient(clientMock);
		assertEquals(new ArrayList<Client>(), bankTest.getClientsList());
	}
	
	@Test(expected=BankWrongNameException.class)
	public void testBankWrongName(){
		Bank bankWrongName = new Bank("Bank1");
	}
	
	
}
