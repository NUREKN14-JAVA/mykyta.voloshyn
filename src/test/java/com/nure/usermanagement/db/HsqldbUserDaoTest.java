package main.java.com.nure.usermanagement.db;

import junit.framework.TestCase;
import main.java.com.nure.usermanagement.User;

import java.util.Date;

/**
 * Created by VSV on 22/01/17.
 */
public class HsqldbUserDaoTest extends TestCase {

    HsqldbUserDao dao;

    public void setUp() throws Exception {
        super.setUp();
        dao = new HsqldbUserDao();
    }

    public void testCreate() throws Exception {
        try {
            User user = new User();
            user.setFirstname("John");
            user.setLastName("Doe");
            user.setDateOfBirthd(new Date());
            assertNull(user.getId());
            user = dao.create(user);
            assertNotNull(user);
            assertNotNull(user.getId());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

}