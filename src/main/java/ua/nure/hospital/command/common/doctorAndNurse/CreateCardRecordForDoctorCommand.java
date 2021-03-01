package ua.nure.hospital.command.common.doctorAndNurse;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceCardRecord;
import ua.nure.hospital.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CreateCardRecordForDoctorCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PatienceCardRecord patienceCardRecord = new PatienceCardRecord();
        User patience = new User();
        User doctor = new User();
        patience.setId(Integer.parseInt(request.getParameter("patienceId")));
        doctor.setId(Integer.parseInt(request.getParameter("doctorId")));
        patienceCardRecord.setDoctor(doctor);
        patienceCardRecord.setPatience(patience);
        patienceCardRecord.setProcedures(request.getParameter("procedures"));
        patienceCardRecord.setMedicines(request.getParameter("medicines"));
        Date date = new Date();
        patienceCardRecord.setDate_of_set(date);
        if (request.getParameter("forDoctor").equals("true")) {
            patienceCardRecord.setOperations(request.getParameter("operations"));
            patienceCardRecord.setDiagnosis(request.getParameter("diagnosis"));
            patienceCardRecordService.addPatienceCardRecordForDoctor(patienceCardRecord);
        } else {
            patienceCardRecordService.addPatienceCardRecordForNurse(patienceCardRecord);
        }
        request.setAttribute("message", "Card record created successfully");
        return Page.SUCCESS;
    }
}
