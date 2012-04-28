package net.therap.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnectionProvider {

    private static Connection connection;
    private static final Logger log = LoggerFactory.getLogger(DbConnectionProvider.class);


    public static Connection getConnection() throws Exception {

        if (connection == null||connection.isClosed()) {
            Context initContext = null;
            try {
                initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
                connection = ds.getConnection();
                log.debug("Database connection successful");
            } catch (NamingException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            connection.close();
            log.debug("Database connection closed");
        }
    }
}
