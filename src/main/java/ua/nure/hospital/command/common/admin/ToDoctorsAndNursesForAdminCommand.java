package ua.nure.hospital.command.common.admin;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToDoctorsAndNursesForAdminCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String order = "sername";
        if (!ObjectUtils.isEmpty(request.getParameter("filter"))) {
            order = request.getParameter("filter");
        }
        request.setAttribute("filter", order);
        request.setAttribute("doctorsAndNurses",
                userService.getDoctorsWithActiveAndCompletePatienceWithNursesWithoutLoginAndPasswordOrderBy(order));
        return Page.ADMIN_DOCTORS_AND_NURSES;
    }
}
