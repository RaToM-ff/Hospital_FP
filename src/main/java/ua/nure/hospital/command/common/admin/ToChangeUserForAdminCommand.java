package ua.nure.hospital.command.common.admin;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToChangeUserForAdminCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("changeUserId", Integer.parseInt(request.getParameter("changeUserId")));
        User user = userService.getUserById(Integer.parseInt(request.getParameter("changeUserId")));
        if (user.getStatus().getId() == 4) {
            request.setAttribute("worksForDoctor", workService.getAllDoctorsWorks());
            request.setAttribute("oldWorkForDoctor", request.getParameter("doctorOldWork"));
        }
        request.setAttribute("statusChangeUser", user.getStatus().getId());
        request.setAttribute("login", user.getLogin());
        request.setAttribute("name", user.getName());
        request.setAttribute("sername", user.getSername());
        request.setAttribute("patronymic", user.getPatronymic());
        request.setAttribute("birthday", user.getBirthday());
        request.setAttribute("statusIdChangeUser", user.getStatus().getId());
        request.setAttribute("workIdChangeUser", user.getWork().getId());
        return Page.ADMIN_CHANGE_DELETE_USER;
    }
}
