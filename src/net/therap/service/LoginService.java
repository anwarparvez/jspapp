package net.therap.service;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/22/12
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginService {
        public boolean authenticate(String userName, String password) {
        if (password != null && password != "") {
            return true;
        } else {
            return false;
        }
    }
}
