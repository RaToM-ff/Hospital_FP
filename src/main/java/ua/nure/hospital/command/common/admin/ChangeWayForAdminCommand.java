package ua.nure.hospital.command.common.admin;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.FileSaverConstants;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.utils.validators.ChangeFinishWay;
import ua.nure.hospital.utils.validators.ChangeNotFinishWay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;


public class ChangeWayForAdminCommand extends Command {

    public static Logger logger = Logger.getLogger(ChangeWayForAdminCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        PatienceWay patienceWay = patienceWayService.getPatienceWayById(Integer.parseInt(request.getParameter("changeWayId")));
        if (request.getParameter("changeFinishFlag") == null) {
            User doctor = new User();
            User patience = new User();
            int patienceChangeWay = Integer.parseInt(
                    request.getParameter("patienceChangeWay"));
            int doctorChangeWay = Integer.parseInt(
                    request.getParameter("doctorChangeWay"));
            patience.setId(patienceChangeWay);
            doctor.setId(doctorChangeWay);
            patienceWay.setPatience(patience);
            patienceWay.setDoctor(doctor);
            try {
                patienceWay.setDate_come(new SimpleDateFormat("yyyy-MM-dd")
                        .parse(request.getParameter("dateComeChangeWay")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Map<String, String> errors = ChangeNotFinishWay.validateWay(patienceWay);
            if (ObjectUtils.isNotEmpty(errors)) {
                request.setAttribute("errors", errors);
                request.setAttribute("changeWayId", Integer.parseInt(
                        request.getParameter("changeWayId")));
                return new ToChangeWayForAdminCommand().execute(request, response);
            }
            if (!patienceWayService.updatePatienceWay(patienceWay)) {
                return Page.ERROR;
            }
        } else {
            //change finish way
            patienceWay.setDiagnosis(request.getParameter("diagnosisChangeWay"));
            try {
                patienceWay.setDate_out(new SimpleDateFormat("yyyy-MM-dd")
                        .parse(request.getParameter("dateOutChangeWay")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Map<String, String> errors = ChangeFinishWay.validateWay(
                    patienceWay,
                    false);
            if (ObjectUtils.isNotEmpty(errors)) {
                request.setAttribute("errors", errors);
                request.setAttribute("changeWayId", request.getParameter("changeWayId"));
                return new ToChangeWayForAdminCommand().execute(request, response);
            }
            //doc saver here
            if (request.getParameter("fileWasUploading").equals("yes")) {
                Part filePart = request.getPart("documentWayUpload");
                String name = String.valueOf(
                        patienceWay.getPatience().getId())
                        + patienceWay.getDoctor().getId()
                        + patienceWay.getId();
                patienceWay.setDocumentWay(fileSaver.save(
                        filePart.getInputStream(),
                        FileSaverConstants.FOLDER_PATH,
                        FileSaverConstants.FOLDER_PATH_ALT,
                        name));
            }
            //doc saver
            if (!patienceWayService.updatePatienceWayToFinal(patienceWay)) {
                return Page.ERROR;
            }
        }
        session.setAttribute("message", "WAY_CHANGED_SUCCESSFULLY");
        return Page.SUCCESS;
    }

}
