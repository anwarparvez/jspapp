package net.therap.controller;

import net.therap.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserController extends
        HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/user/show.jsp");
            requestDispatcher.forward(req, resp);
            return;
        } else {
            writer.print("No User Found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/user/show.jsp");
            requestDispatcher.forward(req, resp);
            return;
        } else {
            writer.print("No User Found");
        }
    }
}
