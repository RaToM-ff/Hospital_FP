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

public class ChangeUserByAdminCommand extends Command {

    public static Logger logger = Logger.getLogger(ChangeUserByAdminCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = new User();
        Work work = new Work();
        Status status = new Status();
        user.setLogin(request.getParameter("login"));
        int id = Integer.parseInt(request.getParameter("changeUserId"));
        user.setId(id);
        user.setName(request.getParameter("name"));
        user.setSername(request.getParameter("sername"));
        user.setPatronymic(request.getParameter("patronymic"));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd")
                    .parse(request.getParameter("birthday")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        work.setId(Integer.parseInt(request.getParameter("workIdChangeUser")));
        status.setId(Integer.parseInt(request.getParameter("statusIdChangeUser")));
        user.setWork(work);
        user.setStatus(status);
        Map<String, String> errors = CreateOrChangeUser.validateRegistration(user, false);
        if (!ObjectUtils.isEmpty(errors)) {
            request.setAttribute("errors", errors);
            request.setAttribute("changeUserId", user.getId());
            return new ToChangeUserForAdminCommand().execute(request, response);
        }
        request.setAttribute("test", "test");
        session.setAttribute("message", "USER_CHANGED_SUCCESSFULLY");
        if (!ObjectUtils.isEmpty(request.getParameter("password"))) {
            StringBuilder newPass = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                newPass.append((int) (Math.random() * 10));
            }
            user.setPassword(cryptPassword.encryptPassword(newPass.toString()));
            if (!userService.updateUserPasswordById(user)) {
                return Page.ERROR;
            }
            session.setAttribute("message", "USER_CHANGED_SUCCESSFULLY_NEW_PASS");
            session.setAttribute("newPass", "<b>" + newPass + "</b>");
        }
        if (!userService.updateUserWithoutLoginAndPasswordById(user)) {
            return Page.ERROR;
        }
        if (!userService.updateUserLoginById(user)) {
            return Page.ERROR;
        }
        logger.info("ALL WORK");
        return Page.SUCCESS;
    }
}
