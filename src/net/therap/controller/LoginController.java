package net.therap.controller;


import net.therap.dao.DBTemplate;
import net.therap.dao.DbConnectionProvider;
import net.therap.dao.UserDao;
import net.therap.dao.UserDaoImpl;
import net.therap.service.LoginService;
import org.apache.catalina.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;


public class LoginController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate(userName, password);
        UserDao userDao = new UserDaoImpl();

        if (result == true) {
            HttpSession session = req.getSession();
            session.setAttribute("user", userDao.get(1));
            resp.sendRedirect("user");
        } else {
            resp.sendRedirect("login");
        }
    }
}
