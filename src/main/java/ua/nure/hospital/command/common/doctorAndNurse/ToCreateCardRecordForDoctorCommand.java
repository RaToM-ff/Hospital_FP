package ua.nure.hospital.command.common.doctorAndNurse;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToCreateCardRecordForDoctorCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User patience = userService.getUserById(Integer.parseInt(request.getParameter("patienceId")));
        request.setAttribute("patience",patience);
        HttpSession session = request.getSession();
        request.setAttribute("forBackButton", request.getParameter("forBackButton"));
        request.setAttribute("doctorId",session.getAttribute("currentUserId"));
        request.setAttribute("statusId",session.getAttribute("currentStatusId"));
        return Page.DOCTOR_AND_NURSE_NEW_CARD_RECORD;
    }
}
