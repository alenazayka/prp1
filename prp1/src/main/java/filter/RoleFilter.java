package filter;

import model.User;
import service.UserService;
import service.UserServiceImpl;
import servlet.StarterPageServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

    @WebFilter(
            urlPatterns = "/*",
            filterName = "RoleFilter")
    public class RoleFilter implements javax.servlet.Filter {
        private UserService userService = UserServiceImpl.getINSTANCE();

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }
        @Override
        public void doFilter(
                ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

                HttpSession session = req.getSession();
            User user = userService.getUserByLogin((String)session.getAttribute("login"));

                if(user.getRole().equals("user")){
                    if(!req.getRequestURL().toString().equals("/user")||!req.getRequestURL().toString().equals("/"))
                    res.sendRedirect("deniedPage.jsp");
                    chain.doFilter(request, response);
                }

        }
        @Override
        public void destroy() {
        }

    }
