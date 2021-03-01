package ua.nure.hospital.command.common;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        userService.deleteUserById(Integer.parseInt(request.getParameter("changeUserId")));
        if (ObjectUtils.isEmpty(userService.getUserById(Integer.parseInt(request.getParameter("changeUserId"))).getWork())) {
            request.setAttribute("message","User deleted successfully");
            return Page.SUCCESS;
        } else {
            request.setAttribute("message","Something goes wrong. Try again or call developer");
            return Page.ERROR;
        }
    }
}
