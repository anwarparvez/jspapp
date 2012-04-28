package net.therap.dao;

import net.therap.domain.FoodVoting;
import net.therap.domain.User;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
        String queryString = "insert into SP_FOOD_RANKING(ID,FOOD_ID,USER_ID,VOTING_DATE,RANKING) values(sp_food_vote.nextval,?, ?,?,?)";
        PreparedStatement preparedStatement = DbConnectionProvider.getConnection().prepareStatement(queryString);
        preparedStatement.setInt(1, foodVoting.getFoodId());
        preparedStatement.setInt(2, foodVoting.getUserId());
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        preparedStatement.setDate(3, sqlDate);
        preparedStatement.setInt(4, foodVoting.getRanking());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DbConnectionProvider.closeConnection();
    }

    public FoodVoting getByUserAndDate(User user, Date date) throws Exception {

        FoodVoting foodVoting = null;
        String queryString =
                "select ID,FOOD_ID,USER_ID,VOTING_DATE,RANKING FROM SP_FOOD_RANKING " +
                        " where VOTING_DATE= ? and user_id=?";
        PreparedStatement preparedStatement = DbConnectionProvider.getConnection().prepareStatement(queryString);
        preparedStatement.setDate(1, date);
        preparedStatement.setInt(2, user.getId());
        ResultSet rs = preparedStatement.executeQuery();
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
        preparedStatement.close();
        DbConnectionProvider.closeConnection();
        return foodVoting;
    }

    public Map<String, Integer> getResultByResult(Date date) throws Exception {
        Map<String, Integer> votMap = new HashMap<String, Integer>();
        String queryString =
                "select avg(ranking) as vote,FOOD_NAME FROM SP_FOOD_RANKING ,SP_FOOD where VOTING_DATE= ? " +
                        "and SP_FOOD_RANKING.food_id= sp_food.food_id group by FOOD_Name";
        PreparedStatement preparedStatement = DbConnectionProvider.getConnection().prepareStatement(queryString);
        preparedStatement.setDate(1, date);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            //int user_id = rs.getInt(1);
            votMap.put(rs.getString(2), rs.getInt(1));
            log.debug("Voting ID=" + rs.getInt(1));
        }
        preparedStatement.close();
        DbConnectionProvider.closeConnection();
        return votMap;
    }

    public Map<String, Float> getResultByDate(Date date) throws Exception {
        Map<String, Float> votMap = new LinkedHashMap<String, Float>();
        String selectString =
                "select avg(ranking) as vote,FOOD_NAME FROM SP_FOOD_RANKING ,SP_FOOD where VOTING_DATE= ? " +
                        "and SP_FOOD_RANKING.food_id= sp_food.food_id group by FOOD_Name order by vote desc ";

        PreparedStatement preparedStatement = DbConnectionProvider.getConnection().prepareStatement(selectString);
        preparedStatement.setDate(1, date);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            votMap.put(rs.getString(2), rs.getFloat(1));
            log.debug("Voting ID=" + rs.getInt(1));
        }
        preparedStatement.close();
        DbConnectionProvider.closeConnection();
        return votMap;
    }

}
