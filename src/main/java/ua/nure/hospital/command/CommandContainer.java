package ua.nure.hospital.command;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.common.*;
import ua.nure.hospital.command.common.admin.*;
import ua.nure.hospital.command.common.doctorAndNurse.*;
import ua.nure.hospital.command.common.patience.ToCardRecordsForPatienceCommand;
import ua.nure.hospital.command.common.patience.ToWaysForPatienceCommand;

public class CommandContainer {

    private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        commands.put("login", new LoginCommand());
        commands.put("changeLogin", new ChangeLoginCommand());
        commands.put("changePasswordByUser", new ChangePasswordByUserCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("toCardRecordsForPatience", new ToCardRecordsForPatienceCommand());
        commands.put("toWaysForPatience", new ToWaysForPatienceCommand());
        commands.put("backToCabinetCommand", new BackToCabinetCommand());
        commands.put("toPatienceForAdmin", new ToPatienceForAdminCommand());
        commands.put("toSetDoctorForWayForAdmin", new ToSetDoctorForWayForAdminCommand());
        commands.put("createNewWay", new CreateNewWayCommand());
        commands.put("toAddNewUserForAdmin", new ToAddNewUserForAdminCommand());
        commands.put("createNewUser", new CreateNewUserCommand());
        commands.put("toChangeUserForAdmin", new ToChangeUserForAdminCommand());
        commands.put("changeUserByAdmin", new ChangeUserByAdminCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("toWorksForAdmin", new ToWorksForAdminCommand());
        commands.put("changeWorkByAdmin", new ChangeWorkByAdminCommand());
        commands.put("createWorkForAdmin", new CreateWorkForAdminCommand());
        commands.put("toAdminsForAdmin", new ToAdminsForAdminCommand());
        commands.put("toWaysForAdmin", new ToWaysForAdminCommand());
        commands.put("toDoctorsAndNursesForAdmin", new ToDoctorsAndNursesForAdminCommand());
        commands.put("toChangeWayForAdmin", new ToChangeWayForAdminCommand());
        commands.put("reopenWayForAdmin", new ReopenWayForAdminCommand());
        commands.put("deleteWayForAdmin", new DeleteWayForAdminCommand());
        commands.put("changeWayForAdmin", new ChangeWayForAdminCommand());
        commands.put("toPatienceForDoctor", new ToPatienceForDoctorCommand());
        commands.put("toWaysPatiencesForDoctor", new ToWaysPatiencesForDoctorCommand());
        commands.put("toCompleteWayForDoctor", new ToCompleteWayForDoctorCommand());
        commands.put("completeWayForDoctor", new CompleteWayForDoctorCommand());
        commands.put("toAllPatienceWayForDoctor", new ToAllPatienceWayForDoctorCommand());
        commands.put("toCardRecordsCurrentPatienceForDoctor", new ToCardRecordsCurrentPatienceForDoctorCommand());
        commands.put("toDoctorsCardRecordsForDoctor", new ToDoctorsCardRecordsForDoctorCommand());
        commands.put("toCreateCardRecordForDoctor", new ToCreateCardRecordForDoctorCommand());
        commands.put("createCardRecordForDoctor", new CreateCardRecordForDoctorCommand());
        commands.put("toChangeCardRecordForDoctor", new ToChangeCardRecordForDoctorCommand());
        commands.put("changeCardRecordForDoctor", new ChangeCardRecordForDoctorCommand());
        commands.put("deleteCardRecordForDoctor", new DeleteCardRecordForDoctorCommand());
        commands.put("changeLanguage", new ChangeLanguageCommand());

        LOG.debug("Command container was successfully initialized");
        LOG.trace("Number of commands --> " + commands.size());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }
}