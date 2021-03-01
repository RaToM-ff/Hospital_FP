package ua.nure.hospital.command.common.doctorAndNurse;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ToWaysPatiencesForDoctorCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String order = "sername";
        if (!ObjectUtils.isEmpty(request.getParameter("filter"))) {
            order = request.getParameter("filter");
        }
        request.setAttribute("filter", order);
        HttpSession session = request.getSession();
        List<User> users = userService.getPatiencesForDoctorByDoctorIdOnWaysOrderBy((int) session.getAttribute("currentUserId"),order);
        request.setAttribute("patiences", users);
        if (ObjectUtils.isEmpty(users)) {
            request.setAttribute("null_p", "You don't have way's patiences now.");
        }
        return Page.DOCTOR_AND_NURSE_DOCTOR_PATIENCES;
    }
}
