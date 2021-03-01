package ua.nure.hospital.command.common.doctorAndNurse;

import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCardRecordForDoctorCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        patienceCardRecordService.deletePatienceCardRecordForDoctorById(Integer.parseInt(request.getParameter("deleteCardRecordId")));
        request.setAttribute("message", "Card record deleted successfully");
        return Page.SUCCESS;
    }
}
