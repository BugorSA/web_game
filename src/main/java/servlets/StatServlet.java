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
import java.util.ArrayList;
import java.util.List;

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
        //рейтинг игроков
        List<User> users = userDAO.findAllUser();
        List<String> list = new ArrayList<>();
        for (User user1 : users) {
            list.add(user1.getLogin() + ": " + Average(user1));
        }
        req.setAttribute("listPlayer", list);
        //история побед
        User user = userDAO.getByLogin(String.valueOf(session.getAttribute("login")));
        req.setAttribute("stats", user.getGameList());
        req.setAttribute("average", Average(user));
        req.getRequestDispatcher("/stat.jsp").forward(req, resp);
    }

    //находит среднее кол-во ходов до выйгрыша
    private float Average(User user) {
        float average = 0;
        int count = 0;
        if (nonNull(user.getGameList())) {
            for (Game game : user.getGameList()) {
                count++;
                average += game.getNum_try();
            }
            average = average / count;
        }
        return average;
    }
}
