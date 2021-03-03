package ua.nure.hospital.command.common;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.utils.validators.ChangeLogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ChangeLoginCommand extends Command {

    public static Logger logger = Logger.getLogger(ChangeLoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = userService.getUserById((int) session.getAttribute("currentUserId"));
        Map<String, String> errors = ChangeLogin.validateLogin(request.getParameter("login"));
        if (!ObjectUtils.isEmpty(errors)) {
            request.setAttribute("errors", errors);
            request.setAttribute("login", request.getParameter("login"));
            return Page.CABINET_CHANGE_LOGIN;
        }
        if (userService.getExistUserByLogin(request.getParameter("login"))) {
            errors.put("login", "BUSI_LOGIN");
            request.setAttribute("errors", errors);
            request.setAttribute("login", request.getParameter("login"));
            return Page.CABINET_CHANGE_LOGIN;
        }
        user.setLogin(request.getParameter("login"));
        userService.updateUserLoginById(user);
        request.setAttribute("message", "");
        return Page.SUCCESS;
    }
}
