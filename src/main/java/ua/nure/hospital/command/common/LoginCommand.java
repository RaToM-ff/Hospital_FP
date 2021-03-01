package ua.nure.hospital.command.common;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;

public class LoginCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //userService.getExistUserByLogin(request.getParameter("login"));
        //logger.info("User --> " + user);
        //user.getId() == (int) session.getAttribute("userId")
        //logger.info("User --> " + user);
        //logger.info("Check --> " + ObjectUtils.isEmpty(user));
        /*logger.info("User list: ");
        for (User us : userService.getAllUsers()) {
            logger.info("User --> " + us);
        }*/
        if (request.getParameter("login") == "" || request.getParameter("password") == "") {
            request.setAttribute("errorMessage", "Some field is empty!");
            request.setAttribute("oldLogin", request.getParameter("login"));
            return Page.LOGIN;
        }
        User user = userService.getUserByLoginAndPassword(request.getParameter("login"), cryptPassword.encryptPassword(request.getParameter("password")));
        logger.info(user);
        if (ObjectUtils.isEmpty(user.getStatus())) {
            request.setAttribute("errorMessage", "Login or Password is wrong!");
            request.setAttribute("oldLogin", request.getParameter("login"));
            return Page.LOGIN;
        }
        request.setAttribute("user", userService.getUserById(user.getId()));
        HttpSession session = request.getSession();
        session.setAttribute("currentUserId", user.getId());
        session.setAttribute("currentStatusId", user.getStatus().getId());
        return Page.CABINET_CABINET;
    }
}
