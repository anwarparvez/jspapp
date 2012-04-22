package net.therap.dao;

import net.therap.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: parvez
 * Date: 4/22/12
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl implements UserDao{
    public void save(User user) {

    }

    public User get(int userId) {
        User user =new User();
        user.setAdmin(true);
        user.setFullName("Anwar Parvez");
        user.setPhoneNumber("+8801717449838");
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public User getUserByUserName(String userName) {
        User user =new User();
        user.setAdmin(true);
        user.setFullName("Anwar Parvez");
        user.setPhoneNumber("+8801717449838");
        return user;
    }
}
