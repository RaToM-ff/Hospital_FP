package ua.nure.hospital.command.common.doctorAndNurse;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToCardRecordsCurrentPatienceForDoctorCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String order = "work_name";
        if (!ObjectUtils.isEmpty(request.getParameter("filter"))) {
            order = request.getParameter("filter");
        }
        request.setAttribute("filter", order);
        request.setAttribute("patienceId", request.getParameter("patienceId"));
        request.setAttribute("forBackButton", request.getParameter("forBackButton"));
        HttpSession session = request.getSession();
        request.setAttribute("doctorId",session.getAttribute("currentUserId"));
        request.setAttribute("patienceData", userService.getUserById(Integer.parseInt(request.getParameter("patienceId"))));
        request.setAttribute("cardRecords", patienceCardRecordService.getAllPatienceCardRecordsByIdPatienceOrderBy(
                Integer.parseInt(request.getParameter("patienceId")),order));
        return Page.DOCTOR_AND_NURSE_CURRENT_PATIENCE_CARD_RECORDS;
    }
}
