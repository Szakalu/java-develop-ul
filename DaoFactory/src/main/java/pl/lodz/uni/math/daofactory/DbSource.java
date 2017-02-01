package pl.lodz.uni.math.daofactory;

import java.util.List;

import org.easymock.EasyMock;

import pl.lodz.uni.math.user.User;

public class DbSource implements Source {
	
	private User userMock = EasyMock.createMock(User.class);
	
	private static DbSource databaseInstance = new DbSource();
	
	public static DbSource getInstance() {
		return databaseInstance;
	}

	public List<User> selectAllUsers() {
		List<User> listUserMock = EasyMock.mock(List.class);
		EasyMock.expect(listUserMock.size()).andReturn(1).anyTimes();
		EasyMock.expect(listUserMock.get(1)).andReturn(userMock).anyTimes();
		EasyMock.replay(listUserMock);
		
		return listUserMock;
	}

	public User selectUserById(int id) {
		EasyMock.expect(userMock.getId()).andReturn(id).anyTimes();
		EasyMock.expect(userMock.getName()).andReturn("DB").anyTimes();
		EasyMock.replay(userMock);
		
		return userMock;
	}

}
