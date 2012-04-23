package net.therap.dao;

import net.therap.domain.User;


public interface UserDao {
    void save(User user);

    User get(int userId) throws Exception;

    User getUserByUserName(String userName) throws Exception;
}
