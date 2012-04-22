package net.therap.dao;

import net.therap.domain.User;


public interface UserDao {
    void save(User user);

    User get(int userId);

    User getUserByUserName(String userName);
}
