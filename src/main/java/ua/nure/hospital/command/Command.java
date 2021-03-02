package ua.nure.hospital.command;

import ua.nure.hospital.db.DAO.impl.*;
import ua.nure.hospital.service.*;
import ua.nure.hospital.service.impl.*;
import ua.nure.hospital.utils.CryptPassword;
import ua.nure.hospital.utils.FileSaver;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command implements Serializable {

    protected UserService userService = new UserServiceImpl(new UserDAOImpl());
    protected PatienceCardRecordService patienceCardRecordService = new PatienceCardRecordServiceImpl(new PatienceCardRecordDAOImpl());
    protected WorkService workService = new WorkServiceImpl(new WorkDAOImpl());
    protected StatusService statusService = new StatusServiceImpl(new StatusDAOImpl());
    protected PatienceWayService patienceWayService = new PatienceWayServiceImpl(new PatienceWayDAOImpl());
    protected CryptPassword cryptPassword = new CryptPassword();
    protected FileSaver fileSaver = new FileSaver();
    private static final long serialVersionUID = 8879403039606311780L;

    public abstract String execute(HttpServletRequest request,
                                   HttpServletResponse response) throws IOException, ServletException;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}