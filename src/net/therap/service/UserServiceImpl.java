package net.therap.service;

import net.therap.dao.FoodVotingDao;

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
    public Map<String, Float> getVoteMap() {
        FoodVotingDao foodVotingDao = new FoodVotingDao();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        try {
            return foodVotingDao.getResultByDate(sqlDate);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Map<String, Float> votMap = new HashMap<String, Float>();
            return votMap;
        }
    }
}
