package ua.nure.hospital.command.common.admin;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteWayForAdminCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (!patienceWayService.deletePatienceWayById(Integer.parseInt(request.getParameter("deleteWayId")))) {
            return Page.ERROR;
        }
        session.setAttribute("message", "Way deleted successfully");
        return Page.SUCCESS;
    }
}
