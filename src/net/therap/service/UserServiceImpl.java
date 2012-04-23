package net.therap.service;

import net.therap.dao.FoodVotingDao;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {
    public Map<String, Integer> getVoteMap() {
        FoodVotingDao foodVotingDao = new FoodVotingDao();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        try {
            return foodVotingDao.getResultByResult(sqlDate);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Map<String, Integer> votMap = new HashMap<String, Integer>();
            return votMap;
        }
    }
}
