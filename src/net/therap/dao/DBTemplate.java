package net.therap.dao;

import oracle.jdbc.internal.OracleConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBTemplate {
    // final static String FILENAME = "/home/parvez/Desktop/server.log.2012-03-15";
    // final static String SEARCH_PATTERN = "PROFILER";
    private static final Logger log = LoggerFactory.getLogger(DBTemplate.class);
    Connection con = null;

    public boolean openConnection() {
        try {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            con = DriverManager.getConnection("jdbc:oracle:thin:@db102:1521:THERAP", "trainee", "pass321");
            System.out.print("Connected\n");

            log.debug("Connection ok");
            if (con != null)
                return true;
            else
                return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public OracleConnection openConnection(String className, String url, String userName, String Password) {
        try {
            try {
                Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            OracleConnection con = (OracleConnection) DriverManager.getConnection(url, userName, Password);
            System.out.print("Connected\n");
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet getResultSet(String query) {

        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return rs;
    }

    private void insertQuery(String query) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.execute(query);

        } catch (Exception e) {
            System.out.println("In OracleConnect:updateDB - " + e);
        }
    }


    public void closeConnection() {
        try {
            con.close();
            System.out.println("Disconnected");
        } catch (Exception e) {
            System.out.println("In OracleConnect:close - " + e);
        }
    }

    public static Properties loadPropertiesFromClassPath(String path) throws Exception {

        return loadProperties(DBTemplate.class.getClass().getResourceAsStream(path));
    }

    public static Properties loadProperties(InputStream inputStream) throws Exception {

        Properties prop = new Properties();
        prop.load(inputStream);
        return prop;
    }

    /* public List getList(String query, DBGetList DBGetList) {
            openConnection();
            ResultSet rs = getResultSet(query);
            List list = DBGetList.buildList(rs);
            closeConnection();
            return list;
        }


        public <T> void saveList(List<T> list, DBSaveList<T> dbSaveList) {
            int i = 1;
            openConnection();
            for (T logUrl : list) {
                insertQuery(dbSaveList.getInsertQuery(logUrl, i++));
            }
            closeConnection();

        }
    */
    /* public void buildDB() throws FileNotFoundException {
        BufferedReader reader;

        reader = new BufferedReader(new FileReader("/home/pritom/server.log.2012-03-15"));
        String line;

        try {

            while ((line = reader.readLine()) != null) {
                if (line.contains("PROFILER")) {
                    String lineParserRegx = "(.*URI=\\[)(.+?)(\\])(.*time=)(\\d*)(m?s)(.*)";

                    Long time = Long.parseLong(line.replaceAll(lineParserRegx, "$5"));

                    if (line.replaceAll(lineParserRegx, "$6").equals("s")) {
                        time *= 1000;
                    }
                    String parsedUrl = line.replaceAll(lineParserRegx, "$2");
                    Long parsedTime = time;
                    System.out.println(parsedUrl + parsedTime);
                    openConnection();
                    insertQuery("insert into PP_URL_TABLE values('" + parsedUrl + "' ,'" + parsedTime + "')");
                    closeConnection();

                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e); // LogParserException("", e);
        } finally {
            try {
                reader.close();

            } catch (IOException e) {
                System.out.println("Can't Close the File");
            }
        }


    }*/

}
