package net.therap.filter;

import net.therap.domain.User;
import net.therap.service.FoodVotingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class VotingFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession(false);
        User user = (User) session.getAttribute("user");
        FoodVotingService foodVotingService = new FoodVotingService();
        if (!foodVotingService.votingAccess(user)) {
            log.debug("user is not logged in");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/foodvoting/success.jsp");
            requestDispatcher.forward(request, response);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
