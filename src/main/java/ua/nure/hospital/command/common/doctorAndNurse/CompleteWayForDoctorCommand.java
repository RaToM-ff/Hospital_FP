package ua.nure.hospital.command.common.doctorAndNurse;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CompleteWayForDoctorCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PatienceWay patienceWay = patienceWayService.getPatienceWayById(Integer.parseInt(request.getParameter("finishWayId")));
        patienceWay.setDiagnosis(request.getParameter("diagnosisFinishWay"));
        patienceWay.setDocumentWay(request.getParameter("documentWayFinishWay"));
        Date date1 = new Date();
        patienceWay.setDate_out(date1);
        patienceWayService.updatePatienceWayToFinal(patienceWay);
        request.setAttribute("message", "Way changed successfully");
        return Page.SUCCESS;
    }
}
