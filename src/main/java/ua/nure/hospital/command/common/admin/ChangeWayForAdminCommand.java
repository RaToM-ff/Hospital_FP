package ua.nure.hospital.command.common.admin;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;
import ua.nure.hospital.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MultipartConfig
public class ChangeWayForAdminCommand extends Command {
    public static final String FOLDER_PATH = "D:/Download/learning/EPAM/Practice/Hospital_FP/src/main/webapp/filesWay/";
    public static final String FOLDER_PATH_ALT = "filesWay/";

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PatienceWay patienceWay = patienceWayService.getPatienceWayById(Integer.parseInt(request.getParameter("changeWayId")));
        if (request.getParameter("changeFinishFlag") == null) {
            User doctor = new User();
            logger.info("PIZDEC");
            User patience = new User();
            int patienceChangeWay = Integer.parseInt(request.getParameter("patienceChangeWay"));
            int doctorChangeWay = Integer.parseInt(request.getParameter("doctorChangeWay"));
            patience.setId(patienceChangeWay);
            doctor.setId(doctorChangeWay);
            patienceWay.setPatience(patience);
            patienceWay.setDoctor(doctor);
            String sDate1 = request.getParameter("dateComeChangeWay");
            Date date1 = null;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            patienceWay.setDate_come(date1);
            patienceWayService.updatePatienceWay(patienceWay);
        } else {
            patienceWay.setDiagnosis(request.getParameter("diagnosisChangeWay"));
            //doc saver need here
            Part filePart = request.getPart("documentWayUpload");
            String name = String.valueOf(patienceWay.getPatience().getId()) + patienceWay.getDoctor().getId() +
                    patienceWay.getId();
            patienceWay.setDocumentWay(fileSaver.save(filePart.getInputStream(), FOLDER_PATH, FOLDER_PATH_ALT, name));
            //doc saver
            //patienceWay.setDocumentWay(request.getParameter("documentWayChangeWay"));
            String sDate1 = request.getParameter("dateOutChangeWay");
            Date date1 = null;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            patienceWay.setDate_out(date1);
            patienceWayService.updatePatienceWayToFinal(patienceWay);
        }
        request.setAttribute("message", "Way changed successfully");
        return Page.SUCCESS;
    }

}
