package ua.nure.hospital.command.common.patience;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ToWaysForPatienceCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<PatienceWay> patienceWayFinish = patienceWayService.getPatienceWayForPatienceFinish(
                (int) session.getAttribute("currentUserId"));
        List<PatienceWay> patienceWay = patienceWayService.getPatienceWayForPatienceNotFinish(
                (int) session.getAttribute("currentUserId"));
        request.setAttribute("patienceWaysFinish",
                patienceWayFinish);
        request.setAttribute("patienceWaysNotFinish",
                patienceWay);
        if (ObjectUtils.isEmpty(patienceWayFinish) && ObjectUtils.isEmpty(patienceWay)) {
            request.setAttribute("null_p", "You don't have any ways now.");
        }
        return Page.PATIENCE_WAYS;
    }
}
