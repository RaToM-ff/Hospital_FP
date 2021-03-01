package ua.nure.hospital.command.common.patience;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToWaysForPatienceCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        request.setAttribute("patienceWaysFinish",
                patienceWayService.getPatienceWayForPatienceFinish(
                        (int) session.getAttribute("currentUserId")));
        request.setAttribute("patienceWaysNotFinish",
                patienceWayService.getPatienceWayForPatienceNotFinish(
                        (int) session.getAttribute("currentUserId")));
        return Page.PATIENCE_WAYS;
    }
}
