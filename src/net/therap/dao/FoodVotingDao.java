package net.therap.dao;

import net.therap.domain.FoodVoting;
import net.therap.domain.User;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodVotingDao {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(FoodVotingDao.class);

    public void insert(FoodVoting foodVoting) throws Exception {
        String insertFoodRanking = "insert into SP_FOOD_RANKING(ID,FOOD_ID,USER_ID,VOTING_DATE,RANKING) values(sp_food_vote.nextval,?, ?,?,?)";
        Connection conn = DbConnectionProvider.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(insertFoodRanking);
        pstmt.setInt(1, foodVoting.getFoodId());
        pstmt.setInt(2, foodVoting.getUserId());
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        pstmt.setDate(3, sqlDate);
        pstmt.setInt(4, foodVoting.getRanking());
        pstmt.executeUpdate();
    }

    public FoodVoting getByUserAndDate(User user, Date date) throws Exception {

        FoodVoting foodVoting = null;
        String selectString =
                "select ID,FOOD_ID,USER_ID,VOTING_DATE,RANKING FROM SP_FOOD_RANKING " +
                        " where VOTING_DATE= ? and user_id=?";
        log.debug(selectString);
        Connection con = DbConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(selectString);
        pstmt.setDate(1, date);
        pstmt.setInt(2, user.getId());

        ResultSet rs = pstmt.executeQuery();
        // extract data from the ResultSet
        while (rs.next()) {
            int user_id = rs.getInt(1);
            foodVoting = new FoodVoting();

            foodVoting.setFoodId(rs.getInt(2));
            foodVoting.setUserId(rs.getInt(3));
            foodVoting.setVotingDate(rs.getDate(4));
            foodVoting.setRanking(rs.getInt(5));
            log.debug("Voting ID=" + rs.getInt(1));
        }
        return foodVoting;
    }

    public Map<String, Integer> getResultByResult(Date date) throws Exception {
        Map<String, Integer> votMap=new HashMap<String,Integer>();
        String selectString =
                "select count(*) as vote,FOOD_NAME FROM SP_FOOD_RANKING ,SP_FOOD where VOTING_DATE= ? " +
                        "and SP_FOOD_RANKING.food_id= sp_food.food_id group by FOOD_Name";
           log.debug(selectString);
        Connection con = DbConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(selectString);
        pstmt.setDate(1, date);
        ResultSet rs = pstmt.executeQuery();
        // extract data from the ResultSet
        while (rs.next()) {
            //int user_id = rs.getInt(1);
             votMap.put(rs.getString(2),new Integer(rs.getInt(1)));
            log.debug("Voting ID=" + rs.getInt(1));
        }
        return votMap;
    }

}
