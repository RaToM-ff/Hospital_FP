package ua.nure.hospital.command.common.admin;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateWorkForAdminCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Work work = new Work();
        work.setName(request.getParameter("nameWork"));
        workService.addWork(work);
        request.setAttribute("message","Work created successfully");
        return Page.SUCCESS;
    }
}
