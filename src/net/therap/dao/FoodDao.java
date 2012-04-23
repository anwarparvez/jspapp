package net.therap.dao;

import net.therap.domain.Food;
import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FoodDao {

    Food get(int foodId) throws Exception;
    List<Food> getFoodList() throws Exception;
}
