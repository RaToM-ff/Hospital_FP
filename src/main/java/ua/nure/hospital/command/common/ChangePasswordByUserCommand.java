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

public class ChangePasswordByUserCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = userService.getUserById((int) session.getAttribute("currentUserId"));
        if (cryptPassword.encryptPassword(request.getParameter("oldPassword")).equals(
                userService.getPasswordById((int) session.getAttribute("currentUserId")))
                && request.getParameter("newPassword1").equals(request.getParameter("newPassword2"))) {
            user.setPassword(cryptPassword.encryptPassword(request.getParameter("newPassword1")));
            userService.updateUserPasswordById(user);
            request.setAttribute("user", userService.getUserById(user.getId()));
            return Page.CABINET_CABINET;
        }

        return Page.CABINET_CHANGE_PASSWORD;
    }
}
