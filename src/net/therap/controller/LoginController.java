package net.therap.controller;


import net.therap.domain.User;
import net.therap.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        User user = loginService.authenticate(userName, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            resp.sendRedirect("user");
        } else {
            HttpSession session = req.getSession(false);
            session.invalidate();
            resp.sendRedirect("login");
        }
    }
}
