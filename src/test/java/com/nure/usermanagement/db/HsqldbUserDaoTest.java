package test.java.com.nure.usermanagement.db;

import main.java.com.nure.usermanagement.User;
import main.java.com.nure.usermanagement.db.ConnectionFactory;
import main.java.com.nure.usermanagement.db.ConnectionFactoryImpl;
import main.java.com.nure.usermanagement.db.DatabaseException;
import main.java.com.nure.usermanagement.db.HsqldbUserDao;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import java.util.Collection;
import java.util.Date;

/**
 * Created by VSV on 22/01/17.
 */
public class HsqldbUserDaoTest extends DatabaseTestCase {

    private HsqldbUserDao dao;
    private ConnectionFactory connectionFactory;

    public void setUp() throws Exception {
        super.setUp();
        dao = new HsqldbUserDao(connectionFactory);
    }

    public void testCreate() {
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

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        connectionFactory = new ConnectionFactoryImpl("org.hsqldb.jdbcDriver","jdbc:hsqldb:file:db/usermanagement", "sa", "");
        return new DatabaseConnection(connectionFactory.createConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
        return dataSet;
    }

    public void testFindAll () {
        try {
            Collection collection = dao.findAll();
            assertNotNull("Collection is null",collection);
            assertEquals("Collection size.", 2, collection.size());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }


}