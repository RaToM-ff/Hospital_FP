package ua.nure.hospital.command.common.doctorAndNurse;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceCardRecord;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.utils.validators.CreateOrChangePatienceCardRecordForDoctor;
import ua.nure.hospital.utils.validators.CreateOrChangePatienceCardRecordForNurse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class CreateCardRecordForDoctorCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
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
            Map<String, String> errors = CreateOrChangePatienceCardRecordForDoctor.validatePatienceCardRecord(patienceCardRecord);
            if (!ObjectUtils.isEmpty(errors)) {
                request.setAttribute("errors", errors);
                request.setAttribute("forBackButton", request.getParameter("forBackButton"));
                request.setAttribute("patienceId", patienceCardRecord.getPatience().getId());
                return new ToCreateCardRecordForDoctorCommand().execute(request, response);
            }
            if (!patienceCardRecordService.addPatienceCardRecordForDoctor(patienceCardRecord)) {
                return Page.ERROR;
            }
        } else {
            Map<String, String> errors = CreateOrChangePatienceCardRecordForNurse.validatePatienceCardRecord(patienceCardRecord);
            if (!ObjectUtils.isEmpty(errors)) {
                request.setAttribute("errors", errors);
                request.setAttribute("forBackButton", request.getParameter("forBackButton"));
                request.setAttribute("patienceId", patienceCardRecord.getPatience().getId());
                return new ToCreateCardRecordForDoctorCommand().execute(request, response);
            }
            if (!patienceCardRecordService.addPatienceCardRecordForNurse(patienceCardRecord)) {
                return Page.ERROR;
            }
        }
        session.setAttribute("message", "Card record created successfully");
        return Page.SUCCESS;
    }
}
