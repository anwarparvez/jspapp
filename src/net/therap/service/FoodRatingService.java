package net.therap.service;


import net.therap.dao.FoodDao;
import net.therap.dao.FoodDaoImpl;
import net.therap.domain.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodRatingService {
    public List<Food> getFoodList() {
        FoodDao foodDao = new FoodDaoImpl();
        List<Food> foodList = null;
        try {
            return foodList = foodDao.getFoodList();
        } catch (Exception e) {
            return new ArrayList<Food>();
        }
    }
}
