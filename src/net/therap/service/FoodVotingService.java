package net.therap.service;


import net.therap.dao.FoodDao;
import net.therap.dao.FoodDaoImpl;
import net.therap.dao.FoodVotingDao;
import net.therap.domain.Food;
import net.therap.domain.FoodVoting;
import net.therap.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodVotingService {
    public static Logger log= LoggerFactory.getLogger(FoodVotingService.class) ;
    public List<Food> getFoodList() {
        FoodDao foodDao = new FoodDaoImpl();
        List<Food> foodList = null;
        try {
            return foodDao.getFoodList();
        } catch (Exception e) {
            log.debug("Empty List"+e);
            return new ArrayList<Food>();
        }
    }

    public void setRating(User user, int foodId) {
        FoodVotingDao foodVotingDao = new FoodVotingDao();
        FoodVoting foodVoting = new FoodVoting();
        foodVoting.setFoodId(foodId);
        foodVoting.setRanking(5);
        foodVoting.setUserId(user.getId());
        try {
            foodVotingDao.insert(foodVoting);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void setRating(User user, int foodId, int vote) {
        FoodVotingDao foodVotingDao = new FoodVotingDao();
        FoodVoting foodVoting = new FoodVoting();
        foodVoting.setFoodId(foodId);
        foodVoting.setRanking(vote);
        foodVoting.setUserId(user.getId());
        try {
            foodVotingDao.insert(foodVoting);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public boolean votingAccess(User user) {
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        FoodVotingDao foodVotingDao = new FoodVotingDao();
        try {
            FoodVoting foodVoting = foodVotingDao.getByUserAndDate(user, sqlDate);
            if (foodVoting != null)
                return false;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return true;
        }
        return true;
    }
}
