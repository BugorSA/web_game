package servlets;

import dao.UserDAO;
import game.BullCow;
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


public class GameServlet extends HttpServlet {
    private List<String> stringList;
    private BullCow bullCow;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        bullCow = new BullCow();
        stringList = new ArrayList<>(0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String chars = "";
        chars += req.getParameter("select1");
        chars += req.getParameter("select2");
        chars += req.getParameter("select3");
        chars += req.getParameter("select4");
        String s;
        if (!checkStr(chars)) {
            stringList.add("Нужно ввести 4 разные цифры");
            resp.sendRedirect("/game");
        } else {
            s = bullCow.pushVersion(chars);
            if (bullCow.isWin()) {
                req.setAttribute("try", bullCow.getLogs().size());
                req.setAttribute("num", bullCow.getGuessed_number());
                winnerPost(req);
                stringList.clear();
                bullCow = new BullCow();
                req.getRequestDispatcher("/win.jsp").forward(req, resp);
            } else {
                req.setAttribute("answer", s);
                stringList.add(chars + ": " + s);
                resp.sendRedirect("/game");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.setAttribute("logs", stringList);
        req.setAttribute("logs", stringList);
//        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    private void winnerPost(HttpServletRequest req) {
        Game game = new Game(bullCow.getLogs().size());
        UserDAO dao = new UserDAO();
        final HttpSession session = req.getSession();
        User user = dao.getByLogin(String.valueOf(session.getAttribute("login")));
        user.addGame(game);
        dao.update(user);
    }

    //проверка на кол-во цифр и их уникальность
    private boolean checkStr(String str) {
        if (str.length() == 4) {
            char[] chars = str.toCharArray();
            int a = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        if (chars[i] == chars[j]) {
                            a++;
                        }
                    }
                }
            }
            return (a == 0);
        } else return false;
    }
}