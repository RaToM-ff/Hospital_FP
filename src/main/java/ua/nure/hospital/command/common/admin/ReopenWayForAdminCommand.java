package ua.nure.hospital.command.common.admin;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReopenWayForAdminCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PatienceWay patienceWay = patienceWayService.getPatienceWayById(Integer.parseInt(request.getParameter("reopenWayId")));
        patienceWay.setDocumentWay(null);
        patienceWay.setDiagnosis(null);
        patienceWay.setDate_out(null);
        patienceWayService.updatePatienceWayToFinal(patienceWay);
        //Document delete here
        request.setAttribute("message","Way reopened successfully");
        return Page.SUCCESS;
    }
}
