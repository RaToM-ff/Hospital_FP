package ua.nure.hospital.db.DAO.impl;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.db.DAO.WorkDAO;
import ua.nure.hospital.db.DBManager;
import ua.nure.hospital.entity.Work;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkDAOImpl implements WorkDAO {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public boolean addWork(Work work) {
        ResultSet resultSet = null;
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.INSERT_WORK, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, work.getName());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                work.setId(resultSet.getInt(1));
            }
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public List<Work> getAllWorks() {
        DBManager DBM = DBManager.getInstance();
        List<Work> works = new ArrayList<>();
        try (Statement statement = DBM.getConnection(DBManager.getUrl()).createStatement();
             ResultSet resultSet = statement.executeQuery(DBConstants.SELECT_ALL_WORKS)) {
            while (resultSet.next()) {
                Work work = new Work();
                work.setId(resultSet.getInt(DBConstants.FIELD_WORK_ID));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                works.add(work);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return works;
    }

    @Override
    public List<Work> getAllDoctorsWorks() {
        DBManager DBM = DBManager.getInstance();
        List<Work> works = new ArrayList<>();
        try (Statement statement = DBM.getConnection(DBManager.getUrl()).createStatement();
             ResultSet resultSet = statement.executeQuery(DBConstants.SELECT_ALL_DOCTORS_WORKS)) {
            while (resultSet.next()) {
                Work work = new Work();
                work.setId(resultSet.getInt(DBConstants.FIELD_WORK_ID));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                works.add(work);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return works;
    }

    @Override
    public boolean updateWork(Work work) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.UPDATE_WORK_BY_ID)) {
            preparedS.setString(1, work.getName());
            preparedS.setInt(2, work.getId());
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }
}
