package ua.nure.hospital.command.common.admin;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.Status;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.entity.Work;
import ua.nure.hospital.utils.validators.CreateOrChangeUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class CreateNewUserCommand extends Command {

    public static Logger logger = Logger.getLogger(CreateNewUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = new User();
        Work work = new Work();
        Status status = new Status();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setSername(request.getParameter("sername"));
        user.setPatronymic(request.getParameter("patronymic"));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd")
                    .parse(request.getParameter("birthday")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        work.setId(Integer.parseInt(request.getParameter("workIdAddUser")));
        status.setId(Integer.parseInt(request.getParameter("statusAddUser")));
        user.setWork(work);
        user.setStatus(status);
        Map<String, String> errors = CreateOrChangeUser.validateRegistration(user, true);
        if (ObjectUtils.isNotEmpty(errors)) {
            request.setAttribute("errors", errors);
            request.setAttribute("statusAddUser", user.getStatus().getId());
            return new ToAddNewUserForAdminCommand().execute(request, response);
        }
        //after validator
        user.setPassword(cryptPassword.encryptPassword(user.getPassword()));
        if (!userService.addUser(user)) {
            return Page.ERROR;
        }
        session.setAttribute("message", "User created successfully.");
        return Page.SUCCESS;
    }
}
