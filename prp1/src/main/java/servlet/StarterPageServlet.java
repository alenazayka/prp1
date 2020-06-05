package servlet;


import exception.DBException;
import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class StarterPageServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getINSTANCE();

    @Override
    public void init() throws ServletException {
        super.init();
        userService= UserServiceImpl.getINSTANCE();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User user = new User(login, password);
            userService.authUser(user);
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/starterPage.jsp");
        requestDispatcher.forward(req, resp);
    }
}
