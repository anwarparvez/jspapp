package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.FoodVotingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodVotingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FoodVotingService foodVotingService = new FoodVotingService();
        String food_vote = request.getParameter("food_vote");
                HttpSession session = ((HttpServletRequest) request).getSession(false);
            User user = (User) session.getAttribute("user");
        if (food_vote != null) {
            String vote_list[]=request.getParameterValues("food_vote");
             int food_id=1;
            for(String foodVote:vote_list){
            foodVotingService.setRating(user, food_id++,Integer.parseInt(foodVote));
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/foodvoting/success.jsp");
            requestDispatcher.forward(request, response);

        } else {
            request.setAttribute("foodList", foodVotingService.getFoodList());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/foodvoting/form.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FoodVotingService foodRatingService = new FoodVotingService();
        request.setAttribute("foodList", foodRatingService.getFoodList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/foodvoting/form.jsp");
        requestDispatcher.forward(request, response);
    }

}
