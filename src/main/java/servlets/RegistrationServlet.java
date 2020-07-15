package servlets;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User.ROLE role = User.ROLE.USER;
        User user = new User(login, password, role);
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.findAllUser();
        boolean b = true; //проверка на существование акк
        for (User usr :
                users) {
            if (usr.getLogin().equals(user.getLogin())) {
                PrintWriter printWriter = resp.getWriter();
                printWriter.println("<html>");
                printWriter.println("<h1> such login already exists </h1>");
                printWriter.println("<html>");
                b = false;
            }
        }
        if (b) {
            userDAO.save(user);
            resp.sendRedirect("/hello");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }
}
