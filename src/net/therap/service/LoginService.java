package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.dao.UserDaoImpl;
import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/22/12
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginService {
    public User authenticate(String userName, String password) {
        User user = null;
        UserDao userDao = new UserDaoImpl();
        try {
            user = userDao.getUserByUserName(userName);
            if (password.equals(user.getPassword()))
                return user;
            else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }

    }
}
