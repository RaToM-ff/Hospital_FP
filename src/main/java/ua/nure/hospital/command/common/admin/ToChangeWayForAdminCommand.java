package ua.nure.hospital.command.common.admin;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceWay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToChangeWayForAdminCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("changeWayId", Integer.parseInt(request.getParameter("changeWayId")));
        PatienceWay patienceWay = patienceWayService.getPatienceWayById(Integer.parseInt(request.getParameter("changeWayId")));
        request.setAttribute("doctors", userService.getDoctorsWithActiveAndCompletePatienceWithoutLoginAndPasswordWithOrderBy(DBConstants.FIELD_USER_WORK_ID));
        request.setAttribute("patiences", userService.getPatiencesWithoutLoginAndPasswordOrderBy(DBConstants.FIELD_USER_SERNAME));
        request.setAttribute("way", patienceWay);
        //today create !!NEW META!!
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("dateToday", dateFormat.format(date));
        return Page.ADMIN_CHANGE_WAY;
    }
}
