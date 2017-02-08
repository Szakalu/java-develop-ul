package pl.lodz.uni.math.main;

import java.util.List;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;

import pl.lodz.uni.math.daofactory.DaoFactory;
import pl.lodz.uni.math.daofactory.EnumSourceDaoFactory;
import pl.lodz.uni.math.user.User;

public class Main 
{
    public static void main( String[] args )
    {
    	Logger logger = Logger.getLogger(Main.class.getName());
    	
    	DaoFactory daoFactory = new DaoFactory();
    	daoFactory.setSourceOfData(EnumSourceDaoFactory.DB);
    	daoFactory.getSourceOfData().selectUserById(1);
    	daoFactory.getSourceOfData().selectAllUsers();
    	DaoFactory daoFactory2 = new DaoFactory();
    	daoFactory2.setSourceOfData(EnumSourceDaoFactory.DB);
    	daoFactory2.getSourceOfData().selectUserById(1);
    	daoFactory2.getSourceOfData().selectAllUsers();
    	if(daoFactory.getSourceOfData().getClass().equals(daoFactory2.getSourceOfData().getClass())){
    		logger.info("Good");
    	}
    }
}
