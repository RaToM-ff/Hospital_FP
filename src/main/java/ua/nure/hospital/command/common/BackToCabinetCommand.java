package ua.nure.hospital.command.common;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BackToCabinetCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("currentUserId") == null) {
            request.setAttribute("errorMessage", "Session time is over! ReLogin please.");
            return Page.LOGIN;
        }
        request.setAttribute("user", userService.getUserById((int) session.getAttribute("currentUserId")));
        return Page.CABINET_CABINET;
    }
}
