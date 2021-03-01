package ua.nure.hospital.command.common;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLoginCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //userService.getExistUserByLogin(request.getParameter("login"));
        //logger.info("User --> " + user);
        //user.getId() == (int) session.getAttribute("userId")
        /*int a = (int) session.getAttribute("currentUserId");
        logger.info("A is --> " + a);
        boolean check = userService.getExistUserByLogin(request.getParameter("login"));
        logger.info("Check is --> " + check);*/
        HttpSession session = request.getSession();
        User user = userService.getUserById((int) session.getAttribute("currentUserId"));
        if (!userService.getExistUserByLogin(request.getParameter("login"))
                && !request.getParameter("login").equals("")) {
            user.setLogin(request.getParameter("login"));
            userService.updateUserLoginById(user);
            request.setAttribute("user", userService.getUserById(user.getId()));
            return Page.CABINET_CABINET;
        }
        return Page.CABINET_CHANGE_LOGIN;
    }
}
