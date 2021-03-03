package ua.nure.hospital.command.common.doctorAndNurse;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.FileSaverConstants;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;
import ua.nure.hospital.utils.validators.ChangeFinishWay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class CompleteWayForDoctorCommand extends Command {

    public static Logger logger = Logger.getLogger(CompleteWayForDoctorCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        PatienceWay patienceWay = patienceWayService.getPatienceWayById(Integer.parseInt(request.getParameter("completeWayId")));
        patienceWay.setDiagnosis(request.getParameter("diagnosisFinishWay"));
        Date date1 = new Date();
        patienceWay.setDate_out(date1);
        Map<String, String> errors = ChangeFinishWay.validateWay(patienceWay, request.getParameter("fileWasUploading").equals("no"));
        if (!ObjectUtils.isEmpty(errors)) {
            request.setAttribute("errors", errors);
            request.setAttribute("completeWayId", patienceWay.getId());
            request.setAttribute("forBackButton", request.getParameter("forBackButton"));
            return new ToCompleteWayForDoctorCommand().execute(request, response);
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
        session.setAttribute("message", "WAY_CHANGED_SUCCESSFULLY");
        return Page.SUCCESS;
    }
}
