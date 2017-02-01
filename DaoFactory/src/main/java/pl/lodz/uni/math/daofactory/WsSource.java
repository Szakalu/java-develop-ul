package pl.lodz.uni.math.daofactory;

import java.util.List;

import org.easymock.EasyMock;

import pl.lodz.uni.math.user.User;

public class WsSource implements Source {

	private User userMock = EasyMock.createMock(User.class);
	List<User> listUserMock = EasyMock.mock(List.class);
	
	private static WsSource wsInstance = new WsSource();
	
	public static WsSource getInstance() {
		return wsInstance;
	}
	
	public List<User> selectAllUsers() {
		EasyMock.expect(listUserMock.size()).andReturn(1).anyTimes();
		EasyMock.expect(listUserMock.get(1)).andReturn(userMock).anyTimes();
		EasyMock.replay(listUserMock);
		
		return listUserMock;
	}

	public User selectUserById(int id) {
		EasyMock.expect(userMock.getId()).andReturn(id).anyTimes();
		EasyMock.expect(userMock.getName()).andReturn("WS").anyTimes();
		EasyMock.replay(userMock);
		
		return userMock;
	}


}
