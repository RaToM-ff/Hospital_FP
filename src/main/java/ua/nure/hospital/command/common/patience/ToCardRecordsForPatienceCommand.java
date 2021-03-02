package ua.nure.hospital.command.common.patience;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.Command;
import ua.nure.hospital.constant.Page;
import ua.nure.hospital.entity.PatienceCardRecord;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ToCardRecordsForPatienceCommand extends Command {

    public static Logger logger = Logger.getLogger(ToCardRecordsForPatienceCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String order = "work_name";
        if (!ObjectUtils.isEmpty(request.getParameter("filter"))) {
            order = request.getParameter("filter");
        }
        request.setAttribute("filter", order);
        List<PatienceCardRecord> cardRecord = patienceCardRecordService.getAllPatienceCardRecordsByIdPatienceOrderBy(
                (int) session.getAttribute("currentUserId"), order);
        request.setAttribute("patienceCardRecords", cardRecord);
        if (ObjectUtils.isEmpty(cardRecord)) {
            request.setAttribute("null_p", "You don't have any card records now.");
        }
        return Page.PATIENCE_CARD_RECORDS;
    }
}
