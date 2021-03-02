package ua.nure.hospital.command.common;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.utils.validators.ChangeLogin;
import ua.nure.hospital.utils.validators.ChangePassword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ChangePasswordByUserCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = userService.getUserById((int) session.getAttribute("currentUserId"));

        Map<String, String> errors = ChangePassword.validatePassword(
                request.getParameter("oldPassword"),
                request.getParameter("newPassword1"),
                request.getParameter("newPassword2"));
        if (!ObjectUtils.isEmpty(errors)) {
            request.setAttribute("errors", errors);
            return Page.CABINET_CHANGE_PASSWORD;
        }
        if (!cryptPassword.encryptPassword(request.getParameter("oldPassword")).equals(userService.getPasswordById((int) session.getAttribute("currentUserId")))) {
            errors.put("oldPassword","This password not same with old.");
            request.setAttribute("errors", errors);
            return Page.CABINET_CHANGE_PASSWORD;
        }
        user.setPassword(cryptPassword.encryptPassword(request.getParameter("newPassword1")));
        userService.updateUserPasswordById(user);
        request.setAttribute("message", "Password changed successfully.");
        return Page.SUCCESS;
    }
}
