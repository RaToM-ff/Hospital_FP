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

public class ToDoctorsCardRecordsForDoctorCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String order = "patiencesSername";
        if (!ObjectUtils.isEmpty(request.getParameter("filter"))) {
            order = request.getParameter("filter");
        }
        request.setAttribute("filter", order);
        HttpSession session = request.getSession();
        request.setAttribute("doctorId", session.getAttribute("currentUserId"));
        List<PatienceCardRecord> cardRecord = patienceCardRecordService.getAllPatienceCardRecordsByIdDoctorOrderBy((int) session.getAttribute("currentUserId"), order);
        request.setAttribute("cardRecords", cardRecord);
        if (ObjectUtils.isEmpty(cardRecord)) {
            request.setAttribute("null_p", "You don't have any card records now.");
        }
        return Page.DOCTOR_AND_NURSE_DOCTORS_CARD_RECORDS;
    }
}
