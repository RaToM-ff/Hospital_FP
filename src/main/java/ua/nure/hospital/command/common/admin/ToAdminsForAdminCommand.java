package ua.nure.hospital.command.common.admin;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToAdminsForAdminCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String order = "sername";
        if (!ObjectUtils.isEmpty(request.getParameter("filter"))) {
            order = request.getParameter("filter");
        }
        request.setAttribute("filter", order);
        HttpSession session = request.getSession();
        request.setAttribute("admins",
                userService.getAdminsWithoutLoginAndPasswordOrderBy(
                        (int) session.getAttribute("currentUserId"), order));
        return Page.ADMIN_ADMINS;
    }
}
