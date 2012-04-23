package net.therap.domain;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class Food {
    int foodId;
    String foodName;
    String foodType;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
