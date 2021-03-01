package ua.nure.hospital.command.common.admin;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ToAddNewUserForAdminCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("statusAddUser", request.getParameter("statusAddUser"));
        if (request.getParameter("statusAddUser").equals("4")) {
            request.setAttribute("worksForDoctor",workService.getAllDoctorsWorks());
        }
        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String monthString = null;
        String dayString = null;
        if (month / 10 == 0) {
            monthString = "0" + month;
        } else {
            monthString = "" + month;
        }
        if (day / 10 == 0) {
            dayString = "0" + day;
        } else {
            dayString = "" + day;
        }
        request.setAttribute("dateToday", year + "-" + monthString + "-" + dayString);
        return Page.ADMIN_ADD_USER;
    }
}
