package net.therap.dao;

import net.therap.util.Utils;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionProvider {

    private static Connection connection;
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String urlAdress = "jdbc:oracle:thin:@db102:1521:THERAP";
    private static String user = "trainee";
    private static String password = "pass321";
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DbConnectionProvider.class);

/*    public static Connection getConnection() throws Exception {

        if (connection == null) {
            log.debug("Database connection init");

            Properties prop = Utils.loadPropertiesFromClassPath("ojdbc.properties");
            log.debug(prop.toString());
            Class drvClass = Class.forName(prop.getProperty("jdbc.driver"));
            DriverManager.registerDriver((Driver) drvClass.newInstance());
            log.debug("Getting Database connection");

            connection = DriverManager.getConnection(
                    prop.getProperty("jdbc.url.address"),
                    prop.getProperty("db.user"),
                    prop.getProperty("db.password")
            );

            log.debug("Database connection successful");
        }

        return connection;
    }*/
     public static Connection getConnection() throws Exception {

        if (connection == null) {

            Class drvClass = Class.forName(driver);
            DriverManager.registerDriver((Driver) drvClass.newInstance());
            log.debug("Getting Database connection");

            connection = DriverManager.getConnection(
                    urlAdress,
                    user,
                   password
            );

            log.debug("Database connection successful");
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
