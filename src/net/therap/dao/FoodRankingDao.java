package net.therap.dao;

import net.therap.domain.FoodRanking;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodRankingDao {
    public void insert(FoodRanking foodRanking) throws Exception {

        String insertFoodRanking = "insert into SP_FOOD_RANKING(FOOD_ID,USER_ID,VOTING_DATE,RANKING) values(?, ?,?,?)";
        Connection conn = DbConnectionProvider.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(insertFoodRanking);
        pstmt.setInt(1, foodRanking.getFoodId());
        pstmt.setInt(2, foodRanking.getUserId());
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        pstmt.setDate(3, sqlDate);
        pstmt.setInt(4, foodRanking.getRanking());
        pstmt.executeUpdate();
    }

}
