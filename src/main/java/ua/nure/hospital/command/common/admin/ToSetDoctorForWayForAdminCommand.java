package ua.nure.hospital.command.common.admin;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToSetDoctorForWayForAdminCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String order = "sername";
        if (!ObjectUtils.isEmpty(request.getParameter("filter"))) {
            order = request.getParameter("filter");
        }
        int patienceId = Integer.parseInt(request.getParameter("patienceId"));
        request.setAttribute("patience", userService.getUserById(patienceId));
        request.setAttribute("filter", order);
        request.setAttribute("patienceId", request.getParameter("patienceId"));
        request.setAttribute("doctors",
                userService.getDoctorsWithActiveAndCompletePatienceWithoutLoginAndPasswordWithOrderBy(order));
        return Page.ADMIN_SELECT_DOCTOR_FOR_WAY;
    }

}
