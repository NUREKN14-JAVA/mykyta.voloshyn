package main.java.com.nure.usermanagement.db;

import java.sql.Connection;

/**
 * Created by VSV on 22/01/17.
 */
public interface ConnectionFactory {
    Connection createConnection() throws DatabaseException;
}
