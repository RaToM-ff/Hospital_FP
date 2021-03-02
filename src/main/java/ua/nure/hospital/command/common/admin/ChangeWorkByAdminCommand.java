package ua.nure.hospital.command.common.admin;

import org.apache.commons.lang3.ObjectUtils;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.Work;
import ua.nure.hospital.utils.validators.CreateOrChangeWork;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ChangeWorkByAdminCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Work work = new Work();
        work.setId(Integer.parseInt(request.getParameter("idWork")));
        work.setName(request.getParameter("nameWork"));

        Map<String, String> errors = CreateOrChangeWork.validateWork(work);
        if (!ObjectUtils.isEmpty(errors)) {
            request.setAttribute("errors", errors);
            return new ToWorksForAdminCommand().execute(request, response);
        }
        if (!workService.updateWork(work)) {
            return Page.ERROR;
        }
        session.setAttribute("message", "Work changed successfully.");
        return Page.SUCCESS;
    }

}
