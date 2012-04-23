package net.therap.dao;

import net.therap.domain.User;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: parvez
 * Date: 4/22/12
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl implements UserDao {
    String dbName = "SP_USER";
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserDao.class);

    public void save(User user) {

    }

    public User get(int userId) throws Exception {

        User user = new User();
        ResultSet rs = null;
        PreparedStatement selectUser = null;
        String userPassword = null;
        String userType = null;
        String userName = null;

        String selectString =
                "select * FROM SP_USER " +
                        " where USER_ID = ?";
        Connection con = DbConnectionProvider.getConnection();
        selectUser = con.prepareStatement(selectString);
        selectUser.setInt(1, userId);

        rs = selectUser.executeQuery();
        // extract data from the ResultSet
        while (rs.next()) {
            int user_id = rs.getInt(1);
            userName = rs.getString(2);
            userPassword = rs.getString(3);
            userType = rs.getString(4);
            log.debug(user_id + "\t" + userName + "\t" + userPassword + "\t" + userType);
        }
        if (userType != null) {
            if (userType.equals("admin")) {
                user.setAdmin(true);
            }
        }
        user.setFullName(userName);
        user.setPhoneNumber("+8801717449838");
        user.setPassword(userPassword);
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public User getUserByUserName(String userName) throws Exception {
        User user = new User();
        ResultSet rs = null;
        PreparedStatement selectUser = null;
        String userPassword = null;
        String userType = null;
        int userId = -1;

        String selectString;
        selectString = "select * FROM SP_USER " +
                " where USER_Name = ?";
        Connection con = DbConnectionProvider.getConnection();
        selectUser = con.prepareStatement(selectString);
        selectUser.setString(1, userName);

        rs = selectUser.executeQuery();
        while (rs.next()) {
            userId = rs.getInt(1);
            String user_Name = rs.getString(2);
            userPassword = rs.getString(3);
            userType = rs.getString(4);
            log.debug(userId + "\t" + userName + "\t" + userPassword + "\t" + userType);

        }
        if (userType != null) {
            if (userType.equals("admin")) {
                user.setAdmin(true);
            }
        }
        user.setId(userId);
        user.setFullName(userName);
        user.setPhoneNumber("+8801717449838");
        user.setPassword(userPassword);
        return user;
    }
}
