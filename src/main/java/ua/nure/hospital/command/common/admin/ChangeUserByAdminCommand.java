package ua.nure.hospital.command.common.admin;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.Status;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeUserByAdminCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = new User();
        Work work = new Work();
        Status status = new Status();
        user.setLogin(request.getParameter("login"));
        int id = Integer.parseInt(request.getParameter("changeUserId"));
        user.setId(id);
        request.setAttribute("message","User changed successfully.");
        if(!ObjectUtils.isEmpty(request.getParameter("password"))) {
            StringBuilder newPass = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                newPass.append((int) (Math.random() * 10));
            }
            user.setPassword(cryptPassword.encryptPassword(newPass.toString()));
            userService.updateUserPasswordById(user);
            request.setAttribute("message","User changed successfully. New password: <h2>" + newPass + "</h2>");
        }
        user.setName(request.getParameter("name"));
        user.setSername(request.getParameter("sername"));
        user.setPatronymic(request.getParameter("patronymic"));
        try {
            user.setBirthday( new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        work.setId(Integer.parseInt(request.getParameter("workIdChangeUser")));
        status.setId(Integer.parseInt(request.getParameter("statusIdChangeUser")));
        user.setWork(work);
        user.setStatus(status);
        userService.updateUserWithoutLoginAndPasswordById(user);
        userService.updateUserLoginById(user);
        return Page.SUCCESS;
    }
}
