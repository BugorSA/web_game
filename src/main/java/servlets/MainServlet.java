package servlets;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choice = req.getParameter("mainChoice");
        //ClientService clientService = new ClientService();
        switch (choice) {
            case "new game": {// новая игра
//                req.getRequestDispatcher("/game.jsp").forward(req, resp);
                resp.sendRedirect("/game");
                break;
            }
            case "stat":{// статистика
                //req.setAttribute("clients", clientService.findAllClients());
                //req.getRequestDispatcher("/allClients.jsp").forward(req, resp);
                break;
            }
            case "exit":{// побег
                resp.sendRedirect("/"); //todo сменить в будущем
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
