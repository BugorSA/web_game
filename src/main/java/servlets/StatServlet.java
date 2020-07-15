package servlets;

import dao.UserDAO;
import model.Game;
import model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class StatServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDAO = new UserDAO();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        User user = userDAO.getByLogin(String.valueOf(session.getAttribute("login")));
        req.setAttribute("stats", user.getGameList());
        float average = 0;
        int count = 0;
        if (nonNull(user.getGameList())) {
            for (Game game : user.getGameList()) {
                count++;
                average += game.getNum_try();
            }
            average = average / count;
        }
        req.setAttribute("average", average);
        req.getRequestDispatcher("/stat.jsp").forward(req, resp);
    }
}
