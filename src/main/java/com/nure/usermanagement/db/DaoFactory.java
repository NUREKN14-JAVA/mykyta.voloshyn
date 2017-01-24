package main.java.com.nure.usermanagement.db;

/**
 * Created by VSV on 24/01/17.
 */
import main.java.com.nure.usermanagement.User;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
    public static final String USER_DAO = "dao.com.nure.usermanagement.db.UserDao";
    private final Properties properties;

    private static final DaoFactory INSTANSE = new DaoFactory();

    public static DaoFactory getInstanse() {
        return INSTANSE;
    }

    private DaoFactory() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("settings.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionFactory getConnectionFactory() {
        String user = properties.getProperty("connection.user");
        String password = properties.getProperty("connection.password");
        String url = properties.getProperty("connection.url");
        String driver = properties.getProperty("connection.driver");
        return new ConnectionFactoryImpl(driver, url, user, password);
    }

    public UserDao getUserDao() throws IllegalAccessException, InstantiationException {
        UserDao result = null;
        try {
            Class clazz = Class.forName(properties.getProperty(USER_DAO));
            result = (UserDao) clazz.newInstance();
            result.setConnectionFactory(getConnectionFactory());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
