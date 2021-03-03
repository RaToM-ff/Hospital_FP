package ua.nure.hospital.command.common.admin;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;
import ua.nure.hospital.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class CreateNewWayCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        int patienceId = Integer.parseInt(request.getParameter("patienceId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        PatienceWay patienceWay = new PatienceWay();
        User doctor = new User();
        User patience = new User();
        Date date_come = new Date();
        doctor.setId(doctorId);
        patience.setId(patienceId);
        patienceWay.setPatience(patience);
        patienceWay.setDoctor(doctor);
        patienceWay.setDate_come(date_come);
        if (!patienceWayService.addPatienceWay(patienceWay)) {
            return Page.ERROR;
        }
        session.setAttribute("message", "NEW_WAY_CREATED_SUCCESSFULLY");
        return Page.SUCCESS;
    }
}
