package net.therap.filter;

import net.therap.domain.User;
import net.therap.service.UserService;
import net.therap.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/23/12
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdminFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(AdminFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession(false);
        User user = (User) session.getAttribute("user");
        if (user.isAdmin()) {
            log.debug("Admin Filter Using");
            UserService userService = new UserServiceImpl();
            Map<String, Float> voteMap = userService.getVoteMap();
            session.setAttribute("voteMap", voteMap);
            log.debug("My Map " + voteMap.toString());
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {


    }

}
