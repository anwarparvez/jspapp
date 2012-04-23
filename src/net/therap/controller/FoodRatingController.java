package net.therap.controller;

import net.therap.service.FoodRatingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodRatingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FoodRatingService foodRatingService = new FoodRatingService();
        request.setAttribute("foodList", foodRatingService.getFoodList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/foodvoting/form.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FoodRatingService foodRatingService = new FoodRatingService();
        request.setAttribute("foodList", foodRatingService.getFoodList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/foodvoting/form.jsp");
        requestDispatcher.forward(request, response);

    }

}
