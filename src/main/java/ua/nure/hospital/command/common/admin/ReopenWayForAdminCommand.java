package ua.nure.hospital.command.common.admin;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReopenWayForAdminCommand extends Command {

    public static Logger logger = Logger.getLogger(ReopenWayForAdminCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        PatienceWay patienceWay = patienceWayService.getPatienceWayById(Integer.parseInt(request.getParameter("reopenWayId")));
        patienceWay.setDocumentWay(null);
        patienceWay.setDiagnosis(null);
        patienceWay.setDate_out(null);
        if (!patienceWayService.updatePatienceWayToFinal(patienceWay)) {
            return Page.ERROR;
        }
        session.setAttribute("message", "WAY_REOPENED_SUCCESSFULLY");
        return Page.SUCCESS;
    }
}
