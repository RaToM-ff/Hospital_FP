package ua.nure.hospital.command.common;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.utils.validators.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LoginCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> errors = Login.validateLogin(request.getParameter("login"), request.getParameter("password"));
        if (ObjectUtils.isNotEmpty(errors)) {
            request.setAttribute("errors", errors);
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
