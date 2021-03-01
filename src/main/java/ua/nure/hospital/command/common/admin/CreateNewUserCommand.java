package ua.nure.hospital.command.common.admin;

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

public class CreateNewUserCommand extends Command {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = new User();
        Work work = new Work();
        Status status = new Status();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setSername(request.getParameter("sername"));
        user.setPatronymic(request.getParameter("patronymic"));
        String sDate1 = request.getParameter("birthday");
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirthday(date1);
        work.setId(Integer.parseInt(request.getParameter("workIdAddUser")));
        status.setId(Integer.parseInt(request.getParameter("statusIdAddUser")));
        user.setWork(work);
        user.setStatus(status);
        //after validator
        user.setPassword(cryptPassword.encryptPassword(user.getPassword()));
        userService.addUser(user);
        request.setAttribute("message","User created successfully");
        return Page.SUCCESS;
    }
}
