package ua.nure.hospital.command.common.doctorAndNurse;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToAllPatienceWayForDoctorCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String order = "work_name";
        if (!ObjectUtils.isEmpty(request.getParameter("filter"))) {
            order = request.getParameter("filter");
        }
        request.setAttribute("filter", order);
        request.setAttribute("patienceId", request.getParameter("patienceId"));
        request.setAttribute("forBackButton", request.getParameter("forBackButton"));
        request.setAttribute("patienceData", userService.getUserById(Integer.parseInt(request.getParameter("patienceId"))));
        request.setAttribute("ways", patienceWayService.getAllPatienceWaysByPatienceId(Integer.parseInt(request.getParameter("patienceId")),order));
        return Page.DOCTOR_AND_NURSE_ALL_PATIENCE_WAYS;
    }
}
