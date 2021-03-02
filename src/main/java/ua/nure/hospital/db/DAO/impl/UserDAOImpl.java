package ua.nure.hospital.db.DAO.impl;

import org.apache.log4j.Logger;
import ua.nure.hospital.db.DAO.UserDAO;
import ua.nure.hospital.db.DBManager;
import ua.nure.hospital.entity.Status;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.Work;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public static Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Override
    public boolean addUser(User user) {
        ResultSet resultSet = null;
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getStatus().getId());
            preparedStatement.setInt(4, user.getWork().getId());
            preparedStatement.setString(5, user.getName());
            preparedStatement.setString(6, user.getSername());
            preparedStatement.setString(7, user.getPatronymic());
            preparedStatement.setDate(8, new java.sql.Date(user.getBirthday().getTime()));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        DBManager DBM = DBManager.getInstance();
        List<User> users = new ArrayList<>();
        try (Statement statement = DBM.getConnection(DBManager.getUrl()).createStatement();
             ResultSet resultSet = statement.executeQuery(DBConstants.SELECT_USERS)) {
            while (resultSet.next()) {
                User user = new User();
                Status status = new Status();
                Work work = new Work();
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setLogin(resultSet.getString(DBConstants.FIELD_USER_LOGIN));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
                status.setId(resultSet.getInt(DBConstants.FIELD_USER_STATUS_ID));
                user.setStatus(status);
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                work.setId(resultSet.getInt(DBConstants.FIELD_USER_WORK_ID));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
                users.add(user);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return users;
    }

    @Override
    public boolean updateUserWithoutLoginAndPasswordById(User user) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.UPDATE_USER_ALL_NO_LOG_PASS)) {
            preparedS.setInt(1, user.getStatus().getId());
            preparedS.setInt(2, user.getWork().getId());
            preparedS.setString(3, user.getName());
            preparedS.setString(4, user.getSername());
            preparedS.setString(5, user.getPatronymic());
            preparedS.setDate(6, new java.sql.Date(user.getBirthday().getTime()));
            preparedS.setInt(7, user.getId());
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateUserLoginById(User user) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.UPDATE_USER_LOGIN)) {
            preparedS.setString(1, user.getLogin());
            preparedS.setInt(2, user.getId());
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateUserPasswordById(User user) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.UPDATE_USER_PASSWORD)) {
            preparedS.setString(1, user.getPassword());
            preparedS.setInt(2, user.getId());
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public User getUserById(int id_user) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        User user = new User();
        Status status = new Status();
        Work work = new Work();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id_user);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setLogin(resultSet.getString(DBConstants.FIELD_USER_LOGIN));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
                status.setId(resultSet.getInt(DBConstants.FIELD_USER_STATUS_ID));
                user.setStatus(status);
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                work.setId(resultSet.getInt(DBConstants.FIELD_USER_WORK_ID));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        User user = new User();
        Status status = new Status();
        Work work = new Work();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setLogin(resultSet.getString(DBConstants.FIELD_USER_LOGIN));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
                status.setId(resultSet.getInt(DBConstants.FIELD_USER_STATUS_ID));
                user.setStatus(status);
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                work.setId(resultSet.getInt(DBConstants.FIELD_USER_WORK_ID));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return user;
    }

    @Override
    public User getUserByPasswordAndId(String password, int id_user) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        User user = new User();
        Status status = new Status();
        Work work = new Work();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_BY_PASSWORD_AND_ID)) {
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, id_user);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setLogin(resultSet.getString(DBConstants.FIELD_USER_LOGIN));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
                status.setId(resultSet.getInt(DBConstants.FIELD_USER_STATUS_ID));
                user.setStatus(status);
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                work.setId(resultSet.getInt(DBConstants.FIELD_USER_WORK_ID));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return user;
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        User user = new User();
        Status status = new Status();
        Work work = new Work();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_BY_LOGIN_AND_PASSWORD)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setLogin(resultSet.getString(DBConstants.FIELD_USER_LOGIN));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
                status.setId(resultSet.getInt(DBConstants.FIELD_USER_STATUS_ID));
                user.setStatus(status);
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                work.setId(resultSet.getInt(DBConstants.FIELD_USER_WORK_ID));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return user;
    }

    @Override
    public User getUserByIdWithWorkWithoutPassword(int id) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        User user = new User();
        Work work = new Work();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_BY_ID_WITH_WORK_WITHOUT_PASSWORD)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setLogin(resultSet.getString(DBConstants.FIELD_USER_LOGIN));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                work.setId(resultSet.getInt(DBConstants.FIELD_USER_WORK_ID));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return user;
    }

    @Override
    public User getUserByIdWithStatusAndWorkWithoutPassword(int id) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        User user = new User();
        Status status = new Status();
        Work work = new Work();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_BY_ID_WITH_STATUS_AND_WORK_WITHOUT_PASSWORD)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setLogin(resultSet.getString(DBConstants.FIELD_USER_LOGIN));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
                status.setId(resultSet.getInt(DBConstants.FIELD_USER_STATUS_ID));
                user.setStatus(status);
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                work.setId(resultSet.getInt(DBConstants.FIELD_USER_WORK_ID));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getDoctorsWithActiveAndCompletePatienceWithoutLoginAndPasswordWithOrderBy(String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_DOCTORS_WITH_ACTIVE_AND_COMPLETE_PATIENCE_WITHOUT_LOGIN_AND_PASSWORD_WITH_ORDER.replace("replaceColumn", orderBy))) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                Work work = new Work();
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
                user.setActivePatience(resultSet.getInt("CompletePatience"));
                user.setCompletePatience(resultSet.getInt("ActivePatience"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return users;
    }

    @Override
    public List<User> getDoctorsWithActiveAndCompletePatienceWithNursesWithoutLoginAndPasswordOrderBy(String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_DOCTORS_WITH_ACTIVE_AND_COMPLETE_PATIENCE_AND_NURSES_WITHOUT_LOGIN_AND_PASSWORD_WITH_ORDER.replace("replaceColumn", orderBy))) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                Work work = new Work();
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                work.setId(resultSet.getInt(DBConstants.FIELD_USER_WORK_ID));
                user.setWork(work);
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
                user.setActivePatience(resultSet.getInt("CompletePatience"));
                user.setCompletePatience(resultSet.getInt("ActivePatience"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return users;
    }

    @Override
    public List<User> getPatiencesWithoutLoginAndPasswordOrderBy(String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_PATIENCES_WITHOUT_LOGIN_AND_PASSWORD_WITH_ORDER.replace("replaceColumn", orderBy))) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
                users.add(user);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return users;
    }

    @Override
    public List<User> getAdminsWithoutLoginAndPasswordOrderBy(int id, String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_ADMINS_WITHOUT_LOGIN_AND_PASSWORD_WITH_ORDER.replace("replaceColumn", orderBy))) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
                users.add(user);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return users;
    }

    @Override
    public List<User> getPatiencesForDoctorByDoctorIdOnWaysOrderBy(int doctor_id, String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_USER_PATIENCES_FOR_DOCTOR_BY_DOCTOR_ID_ON_WAYS_WITH_ORDER.replace("replaceColumn", orderBy))) {
            preparedStatement.setInt(1, doctor_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(DBConstants.FIELD_USER_ID));
                user.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                user.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                user.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                user.setBirthday(resultSet.getDate(DBConstants.FIELD_USER_BIRTHDAY));
                user.setDateCome(resultSet.getDate("dateCome"));
                user.setIdWay(resultSet.getInt("IdWay"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return users;
    }

    @Override
    public boolean deleteUserById(int id) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.DELETE_USER_BY_ID)) {
            preparedS.setInt(1, id);
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public boolean getExistUserByLogin(String login) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        int i = 0;
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.COUNT_USER_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                i = resultSet.getInt("number");
            }
            if (i > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return false;
    }

    @Override
    public String getPasswordById(int id) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        String password = null;
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PASSWORD_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return password;
    }
}
