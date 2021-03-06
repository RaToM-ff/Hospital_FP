package ua.nure.hospital.command.common.doctorAndNurse;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceCardRecord;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
        request.setAttribute("doctorId", session.getAttribute("currentUserId"));
        request.setAttribute("patienceData", userService.getUserById(Integer.parseInt(request.getParameter("patienceId"))));
        List<PatienceCardRecord> patienceCardRecord = patienceCardRecordService.getAllPatienceCardRecordsByIdPatienceOrderBy(
                Integer.parseInt(request.getParameter("patienceId")), order);
        request.setAttribute("cardRecords", patienceCardRecord);
        if (ObjectUtils.isEmpty(patienceCardRecord)) {
            request.setAttribute("null_p", "This patience don't have any card records now.");
        }
        return Page.DOCTOR_AND_NURSE_CURRENT_PATIENCE_CARD_RECORDS;
    }
}
