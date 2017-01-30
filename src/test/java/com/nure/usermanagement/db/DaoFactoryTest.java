package test.java.com.nure.usermanagement.db;

import junit.framework.TestCase;
import main.java.com.nure.usermanagement.db.DaoFactory;
import main.java.com.nure.usermanagement.db.UserDao;

/**
 * Created by VSV on 24/01/17.
 */
public class DaoFactoryTest extends TestCase {
    public void testGetUserDao() throws Exception {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            assertNotNull("DaoFactory instance is null", daoFactory);
            UserDao userDao = daoFactory.getUserDao();
            assertNotNull("UserDao instance is null", userDao);
        } catch (RuntimeException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

}