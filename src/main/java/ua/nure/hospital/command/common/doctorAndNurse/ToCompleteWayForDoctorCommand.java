package ua.nure.hospital.command.common.doctorAndNurse;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToCompleteWayForDoctorCommand extends Command {

    public static Logger logger = Logger.getLogger(ToCompleteWayForDoctorCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info(request.getParameter("completeWayId"));
        request.setAttribute("way", patienceWayService.getPatienceWayById(Integer.parseInt(request.getParameter("completeWayId"))));
        request.setAttribute("forBackButton", request.getParameter("forBackButton"));
        return Page.DOCTOR_AND_NURSE_COMPLETE_WAY_FOR_PATIENCE;
    }
}
