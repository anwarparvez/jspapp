package net.therap.dao;

import net.therap.domain.Food;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodDaoImpl implements FoodDao {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(FoodDaoImpl.class);

    public Food get(int foodId) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Food> getFoodList() throws Exception {
        List<Food> foods = new ArrayList<Food>();
        ResultSet rs;
        PreparedStatement preparedStatement;

        String query = "select * FROM SP_FOOD ";
        preparedStatement = DbConnectionProvider.getConnection().prepareStatement(query);
       // log.debug("preparedStatement open");
        rs = preparedStatement.executeQuery();
       // log.debug("Food List");
        // extract data from the ResultSet
        while (rs.next()) {
            int foodId = rs.getInt(1);
            String foodName = rs.getString(2);
            String foodType = rs.getString(3);

            Food food = new Food();
            food.setFoodId(foodId);
            food.setFoodName(foodName);
            food.setFoodType(foodType);
            foods.add(food);
            log.debug(foodId + "\t" + foodName + "\t" + foodType);
        }
        preparedStatement.close();
       // log.debug("Connection closed");
        DbConnectionProvider.closeConnection();
        return foods;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
