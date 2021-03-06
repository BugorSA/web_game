package servlets;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String choice = req.getParameter("mainChoice");
        switch (choice) {
            case "new game": {// новая игра
                resp.sendRedirect("/game");
                break;
            }
            case "stat":{// статистика
                resp.sendRedirect("/stat");
                break;
            }
            default:
                new Alert(Alert.AlertType.ERROR, "Ошибка значения", ButtonType.OK).showAndWait();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
