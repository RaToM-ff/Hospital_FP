package ua.nure.hospital.command.common.admin;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteUserCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (!userService.deleteUserById(Integer.parseInt(request.getParameter("changeUserId")))) {
            return Page.ERROR;
        }
        session.setAttribute("message", "USER_DELETED_SUCCESSFULLY");
        return Page.SUCCESS;
    }
}
