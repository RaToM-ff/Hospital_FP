package ua.nure.hospital.web.servlets;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.command.CommandContainer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
@MultipartConfig
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static Logger logger = Logger.getLogger(Controller.class);

    public void init(ServletConfig config) {
        BasicConfigurator.configure();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = CommandContainer.get(req.getParameter("command"));
        String page = command.execute(req, resp);
        //resp.sendRedirect(page);из запроса всё удалится
        req.getRequestDispatcher(page).forward(req, resp);//из запроса ничего не удаляется
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void destroy() {
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
