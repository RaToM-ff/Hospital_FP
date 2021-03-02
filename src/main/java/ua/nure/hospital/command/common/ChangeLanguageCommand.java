package ua.nure.hospital.command.common;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLanguageCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.setAttribute("language", request.getParameter("setLanguage"));
        if (ObjectUtils.isNotEmpty(request.getParameter("fromPage"))) {
            return Page.LOGIN;
        }
        session.setAttribute("message", "Language was changed.");
        return Page.SUCCESS;
    }
}
