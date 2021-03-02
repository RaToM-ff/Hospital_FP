package ua.nure.hospital.command.common.admin;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ToAddNewUserForAdminCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("statusAddUser", request.getParameter("statusAddUser"));
        if (request.getParameter("statusAddUser").equals("4")) {
            request.setAttribute("worksForDoctor", workService.getAllDoctorsWorks());
        }
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("dateToday", dateFormat.format(date));
        return Page.ADMIN_ADD_USER;
    }
}
