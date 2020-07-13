package servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameServlet extends HttpServlet {
    private List<String> stringList;
    private main.java.BullCow bullCow;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        bullCow = new main.java.BullCow(0);
        stringList = new ArrayList<>(0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String chars = "";
        chars += req.getParameter("select1");
        chars += req.getParameter("select2");
        chars += req.getParameter("select3");
        chars += req.getParameter("select4");
        String s;
        s = bullCow.pushVersion(chars);
        req.setAttribute("answer", s);
        stringList.add(chars + ": " + s);
        resp.sendRedirect("/game");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.setAttribute("logs", stringList);
        req.setAttribute("logs", stringList);
//        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }
}